import React, { useState, useEffect } from 'react';
import axios from 'axios';
import { useNavigate } from 'react-router-dom';
import {
  Table, TableBody, TableCell, TableContainer, TableHead, TableRow, Paper,
  Button, Dialog, DialogTitle, DialogContent, DialogActions, TextField,
  Select, MenuItem, InputLabel, FormControl, IconButton, Snackbar, Alert
} from '@mui/material';
import { Add, Edit, Delete, Visibility, Close } from '@mui/icons-material';
import { LocalizationProvider, DatePicker } from '@mui/x-date-pickers';
import { AdapterDateFns } from '@mui/x-date-pickers/AdapterDateFns';

const StudentDetails = () => {
  const [students, setStudents] = useState([]);
  const [batches, setBatches] = useState([]);
  const [openDialog, setOpenDialog] = useState(false);
  const [openViewDialog, setOpenViewDialog] = useState(false);
  const [currentStudent, setCurrentStudent] = useState(null);
  const [isEdit, setIsEdit] = useState(false);
  const [snackbarOpen, setSnackbarOpen] = useState(false);
  const [snackbarMessage, setSnackbarMessage] = useState('');
  const [snackbarSeverity, setSnackbarSeverity] = useState('success');
  const navigate = useNavigate();

  const API_URL = 'http://localhost:8080/api/students';

  useEffect(() => {
    fetchStudents();
    fetchBatches();
  }, []);

  const fetchStudents = async () => {
    try {
      const response = await axios.get(API_URL);
      setStudents(response.data);
    } catch (error) {
      showSnackbar('Error fetching students', 'error');
    }
  };

  const fetchBatches = async () => {
    try {
      const response = await axios.get('http://localhost:8080/api/batches');
      setBatches(response.data);
    } catch (error) {
      showSnackbar('Error fetching batches', 'error');
    }
  };

  const showSnackbar = (message, severity) => {
    setSnackbarMessage(message);
    setSnackbarSeverity(severity);
    setSnackbarOpen(true);
  };

  const handleCloseSnackbar = () => {
    setSnackbarOpen(false);
  };

  const handleOpenCreateDialog = () => {
    setCurrentStudent({
      studentName: '',
      enrollmentDate: new Date(),
      batchType: '',
      status: 'Active',
      email: '',
      mobileNo: '',
      feesType: 'One Time',
      courseName: '',
      batchStartDate: new Date(),
      enquirySource: '',
      counselor: '',
      totalFees: 0,
      discountGiven: 0,
      chargedFees: 0,
      registrationAmount: 0,
      firstInstallmentDate: new Date(),
      firstInstallmentAmount: 0,
      secondInstallmentDate: new Date(),
      secondInstallmentAmount: 0,
      thirdInstallmentDate: new Date(),
      thirdInstallmentAmount: 0,
      fourthInstallmentDate: new Date(),
      fourthInstallmentAmount: 0,
      balanceFees: 0,
      qualification: '',
      passoutYear: new Date().getFullYear(),
      collegeName: '',
      parentName: '',
      parentMobile: '',
      remark: '',
      internshipId: '',
      dob: new Date(),
      batch: { batchName: '' }
    });
    setIsEdit(false);
    setOpenDialog(true);
  };

  const handleOpenEditDialog = (student) => {
    setCurrentStudent({
      ...student,
      enrollmentDate: new Date(student.enrollmentDate),
      batchStartDate: new Date(student.batchStartDate),
      firstInstallmentDate: student.firstInstallmentDate ? new Date(student.firstInstallmentDate) : new Date(),
      secondInstallmentDate: student.secondInstallmentDate ? new Date(student.secondInstallmentDate) : new Date(),
      thirdInstallmentDate: student.thirdInstallmentDate ? new Date(student.thirdInstallmentDate) : new Date(),
      fourthInstallmentDate: student.fourthInstallmentDate ? new Date(student.fourthInstallmentDate) : new Date(),
      dob: student.dob ? new Date(student.dob) : new Date(),
    });
    setIsEdit(true);
    setOpenDialog(true);
  };

  const handleOpenViewDialog = (student) => {
    setCurrentStudent({
      ...student,
      enrollmentDate: new Date(student.enrollmentDate),
      batchStartDate: new Date(student.batchStartDate),
      firstInstallmentDate: student.firstInstallmentDate ? new Date(student.firstInstallmentDate) : null,
      secondInstallmentDate: student.secondInstallmentDate ? new Date(student.secondInstallmentDate) : null,
      thirdInstallmentDate: student.thirdInstallmentDate ? new Date(student.thirdInstallmentDate) : null,
      fourthInstallmentDate: student.fourthInstallmentDate ? new Date(student.fourthInstallmentDate) : null,
      dob: student.dob ? new Date(student.dob) : null,
    });
    setOpenViewDialog(true);
  };

  const handleCloseDialog = () => {
    setOpenDialog(false);
    setOpenViewDialog(false);
  };

  const handleInputChange = (e) => {
    const { name, value } = e.target;
    setCurrentStudent({ ...currentStudent, [name]: value });
  };

  const handleDateChange = (date, field) => {
    setCurrentStudent({ ...currentStudent, [field]: date });
  };

  const handleNumberChange = (e) => {
    const { name, value } = e.target;
    setCurrentStudent({ ...currentStudent, [name]: parseFloat(value) || 0 });
  };

  const handleBatchChange = (e) => {
    const batchName = e.target.value;
    const selectedBatch = batches.find(b => b.batchName === batchName);
    setCurrentStudent({ 
      ...currentStudent, 
      batch: selectedBatch || { batchName } 
    });
  };

  const handleSubmit = async () => {
    try {
      if (isEdit) {
        await axios.put(`${API_URL}/${currentStudent.id}`, currentStudent);
        showSnackbar('Student updated successfully', 'success');
      } else {
        await axios.post(API_URL, currentStudent);
        showSnackbar('Student created successfully', 'success');
      }
      fetchStudents();
      handleCloseDialog();
    } catch (error) {
      showSnackbar(`Error ${isEdit ? 'updating' : 'creating'} student`, 'error');
    }
  };

  const handleDelete = async (id) => {
    try {
      await axios.delete(`${API_URL}/${id}`);
      showSnackbar('Student deleted successfully', 'success');
      fetchStudents();
    } catch (error) {
      showSnackbar('Error deleting student', 'error');
    }
  };

  const formatDate = (date) => {
    return date ? new Date(date).toLocaleDateString() : 'N/A';
  };

  return (
    <LocalizationProvider dateAdapter={AdapterDateFns}>
      <div style={{ padding: '20px' }}>
        <div style={{ display: 'flex', justifyContent: 'space-between', alignItems: 'center', marginBottom: '20px' }}>
          <h1>Student Management</h1>
          <Button
            variant="contained"
            color="primary"
            startIcon={<Add />}
            onClick={handleOpenCreateDialog}
          >
            Add Student
          </Button>
        </div>

        <TableContainer component={Paper}>
          <Table>
            <TableHead>
              <TableRow>
                <TableCell>ID</TableCell>
                <TableCell>Name</TableCell>
                <TableCell>Email</TableCell>
                <TableCell>Mobile</TableCell>
                <TableCell>Course</TableCell>
                <TableCell>Batch</TableCell>
                <TableCell>Status</TableCell>
                <TableCell>Actions</TableCell>
              </TableRow>
            </TableHead>
            <TableBody>
              {students.map((student) => (
                <TableRow key={student.id}>
                  <TableCell>{student.id}</TableCell>
                  <TableCell>{student.studentName}</TableCell>
                  <TableCell>{student.email}</TableCell>
                  <TableCell>{student.mobileNo}</TableCell>
                  <TableCell>{student.courseName}</TableCell>
                  <TableCell>{student.batch?.batchName}</TableCell>
                  <TableCell>{student.status}</TableCell>
                  <TableCell>
                    <IconButton color="primary" onClick={() => handleOpenViewDialog(student)}>
                      <Visibility />
                    </IconButton>
                    <IconButton color="secondary" onClick={() => handleOpenEditDialog(student)}>
                      <Edit />
                    </IconButton>
                    <IconButton color="error" onClick={() => handleDelete(student.id)}>
                      <Delete />
                    </IconButton>
                  </TableCell>
                </TableRow>
              ))}
            </TableBody>
          </Table>
        </TableContainer>

        {/* Create/Edit Dialog */}
        <Dialog open={openDialog} onClose={handleCloseDialog} maxWidth="md" fullWidth>
          <DialogTitle>{isEdit ? 'Edit Student' : 'Add New Student'}</DialogTitle>
          <DialogContent dividers>
            <div style={{ display: 'grid', gridTemplateColumns: '1fr 1fr', gap: '20px', marginTop: '10px' }}>
              <TextField
                label="Student Name"
                name="studentName"
                value={currentStudent?.studentName || ''}
                onChange={handleInputChange}
                fullWidth
                margin="normal"
              />
              <TextField
                label="Email"
                name="email"
                value={currentStudent?.email || ''}
                onChange={handleInputChange}
                fullWidth
                margin="normal"
              />
              <TextField
                label="Mobile No"
                name="mobileNo"
                value={currentStudent?.mobileNo || ''}
                onChange={handleInputChange}
                fullWidth
                margin="normal"
              />
              <DatePicker
                label="Enrollment Date"
                value={currentStudent?.enrollmentDate}
                onChange={(date) => handleDateChange(date, 'enrollmentDate')}
                renderInput={(params) => <TextField {...params} fullWidth margin="normal" />}
              />
              <FormControl fullWidth margin="normal">
                <InputLabel>Batch Type</InputLabel>
                <Select
                  name="batchType"
                  value={currentStudent?.batchType || ''}
                  onChange={handleInputChange}
                >
                  <MenuItem value="Regular">Regular</MenuItem>
                  <MenuItem value="Weekend">Weekend</MenuItem>
                  <MenuItem value="Crash">Crash</MenuItem>
                </Select>
              </FormControl>
              <FormControl fullWidth margin="normal">
                <InputLabel>Status</InputLabel>
                <Select
                  name="status"
                  value={currentStudent?.status || ''}
                  onChange={handleInputChange}
                >
                  <MenuItem value="Active">Active</MenuItem>
                  <MenuItem value="Inactive">Inactive</MenuItem>
                  <MenuItem value="Completed">Completed</MenuItem>
                  <MenuItem value="Dropped">Dropped</MenuItem>
                </Select>
              </FormControl>
              <FormControl fullWidth margin="normal">
                <InputLabel>Batch</InputLabel>
                <Select
                  value={currentStudent?.batch?.batchName || ''}
                  onChange={handleBatchChange}
                  label="Batch"
                >
                  {batches.map((batch) => (
                    <MenuItem key={batch.batchName} value={batch.batchName}>
                      {batch.batchName}
                    </MenuItem>
                  ))}
                </Select>
              </FormControl>
              <TextField
                label="Course Name"
                name="courseName"
                value={currentStudent?.courseName || ''}
                onChange={handleInputChange}
                fullWidth
                margin="normal"
              />
              <DatePicker
                label="Batch Start Date"
                value={currentStudent?.batchStartDate}
                onChange={(date) => handleDateChange(date, 'batchStartDate')}
                renderInput={(params) => <TextField {...params} fullWidth margin="normal" />}
              />
              <TextField
                label="Enquiry Source"
                name="enquirySource"
                value={currentStudent?.enquirySource || ''}
                onChange={handleInputChange}
                fullWidth
                margin="normal"
              />
              <TextField
                label="Counselor"
                name="counselor"
                value={currentStudent?.counselor || ''}
                onChange={handleInputChange}
                fullWidth
                margin="normal"
              />
              <FormControl fullWidth margin="normal">
                <InputLabel>Fees Type</InputLabel>
                <Select
                  name="feesType"
                  value={currentStudent?.feesType || ''}
                  onChange={handleInputChange}
                >
                  <MenuItem value="One Time">One Time</MenuItem>
                  <MenuItem value="Installment">Installment</MenuItem>
                </Select>
              </FormControl>
              <TextField
                label="Total Fees"
                name="totalFees"
                type="number"
                value={currentStudent?.totalFees || 0}
                onChange={handleNumberChange}
                fullWidth
                margin="normal"
              />
              <TextField
                label="Discount Given"
                name="discountGiven"
                type="number"
                value={currentStudent?.discountGiven || 0}
                onChange={handleNumberChange}
                fullWidth
                margin="normal"
              />
              <TextField
                label="Charged Fees"
                name="chargedFees"
                type="number"
                value={currentStudent?.chargedFees || 0}
                onChange={handleNumberChange}
                fullWidth
                margin="normal"
              />
              <TextField
                label="Registration Amount"
                name="registrationAmount"
                type="number"
                value={currentStudent?.registrationAmount || 0}
                onChange={handleNumberChange}
                fullWidth
                margin="normal"
              />
              <DatePicker
                label="First Installment Date"
                value={currentStudent?.firstInstallmentDate}
                onChange={(date) => handleDateChange(date, 'firstInstallmentDate')}
                renderInput={(params) => <TextField {...params} fullWidth margin="normal" />}
              />
              <TextField
                label="First Installment Amount"
                name="firstInstallmentAmount"
                type="number"
                value={currentStudent?.firstInstallmentAmount || 0}
                onChange={handleNumberChange}
                fullWidth
                margin="normal"
              />
              <DatePicker
                label="Second Installment Date"
                value={currentStudent?.secondInstallmentDate}
                onChange={(date) => handleDateChange(date, 'secondInstallmentDate')}
                renderInput={(params) => <TextField {...params} fullWidth margin="normal" />}
              />
              <TextField
                label="Second Installment Amount"
                name="secondInstallmentAmount"
                type="number"
                value={currentStudent?.secondInstallmentAmount || 0}
                onChange={handleNumberChange}
                fullWidth
                margin="normal"
              />
              <TextField
                label="Balance Fees"
                name="balanceFees"
                type="number"
                value={currentStudent?.balanceFees || 0}
                onChange={handleNumberChange}
                fullWidth
                margin="normal"
              />
              <TextField
                label="Qualification"
                name="qualification"
                value={currentStudent?.qualification || ''}
                onChange={handleInputChange}
                fullWidth
                margin="normal"
              />
              <TextField
                label="Passout Year"
                name="passoutYear"
                type="number"
                value={currentStudent?.passoutYear || ''}
                onChange={handleInputChange}
                fullWidth
                margin="normal"
              />
              <TextField
                label="College Name"
                name="collegeName"
                value={currentStudent?.collegeName || ''}
                onChange={handleInputChange}
                fullWidth
                margin="normal"
              />
              <TextField
                label="Parent Name"
                name="parentName"
                value={currentStudent?.parentName || ''}
                onChange={handleInputChange}
                fullWidth
                margin="normal"
              />
              <TextField
                label="Parent Mobile"
                name="parentMobile"
                value={currentStudent?.parentMobile || ''}
                onChange={handleInputChange}
                fullWidth
                margin="normal"
              />
              <DatePicker
                label="Date of Birth"
                value={currentStudent?.dob}
                onChange={(date) => handleDateChange(date, 'dob')}
                renderInput={(params) => <TextField {...params} fullWidth margin="normal" />}
              />
              <TextField
                label="Remark"
                name="remark"
                value={currentStudent?.remark || ''}
                onChange={handleInputChange}
                fullWidth
                margin="normal"
                multiline
                rows={3}
              />
            </div>
          </DialogContent>
          <DialogActions>
            <Button onClick={handleCloseDialog}>Cancel</Button>
            <Button onClick={handleSubmit} color="primary" variant="contained">
              {isEdit ? 'Update' : 'Create'}
            </Button>
          </DialogActions>
        </Dialog>

        {/* View Dialog */}
        <Dialog open={openViewDialog} onClose={handleCloseDialog} maxWidth="md" fullWidth>
          <DialogTitle>Student Details</DialogTitle>
          <DialogContent dividers>
            {currentStudent && (
              <div style={{ display: 'grid', gridTemplateColumns: '1fr 1fr', gap: '20px' }}>
                <div>
                  <h3>Basic Information</h3>
                  <p><strong>Name:</strong> {currentStudent.studentName}</p>
                  <p><strong>Email:</strong> {currentStudent.email}</p>
                  <p><strong>Mobile:</strong> {currentStudent.mobileNo}</p>
                  <p><strong>DOB:</strong> {formatDate(currentStudent.dob)}</p>
                  <p><strong>Enrollment Date:</strong> {formatDate(currentStudent.enrollmentDate)}</p>
                  <p><strong>Status:</strong> {currentStudent.status}</p>
                  <p><strong>Batch:</strong> {currentStudent.batch?.batchName}</p>
                  <p><strong>Course:</strong> {currentStudent.courseName}</p>
                  <p><strong>Batch Start Date:</strong> {formatDate(currentStudent.batchStartDate)}</p>
                </div>
                <div>
                  <h3>Academic Information</h3>
                  <p><strong>Qualification:</strong> {currentStudent.qualification}</p>
                  <p><strong>Passout Year:</strong> {currentStudent.passoutYear}</p>
                  <p><strong>College:</strong> {currentStudent.collegeName}</p>
                </div>
                <div>
                  <h3>Fees Information</h3>
                  <p><strong>Fees Type:</strong> {currentStudent.feesType}</p>
                  <p><strong>Total Fees:</strong> {currentStudent.totalFees}</p>
                  <p><strong>Discount:</strong> {currentStudent.discountGiven}</p>
                  <p><strong>Charged Fees:</strong> {currentStudent.chargedFees}</p>
                  <p><strong>Registration Amount:</strong> {currentStudent.registrationAmount}</p>
                  <p><strong>Balance Fees:</strong> {currentStudent.balanceFees}</p>
                </div>
                <div>
                  <h3>Installments</h3>
                  <p><strong>1st Installment:</strong> {currentStudent.firstInstallmentAmount} on {formatDate(currentStudent.firstInstallmentDate)}</p>
                  <p><strong>2nd Installment:</strong> {currentStudent.secondInstallmentAmount} on {formatDate(currentStudent.secondInstallmentDate)}</p>
                  <p><strong>3rd Installment:</strong> {currentStudent.thirdInstallmentAmount} on {formatDate(currentStudent.thirdInstallmentDate)}</p>
                  <p><strong>4th Installment:</strong> {currentStudent.fourthInstallmentAmount} on {formatDate(currentStudent.fourthInstallmentDate)}</p>
                </div>
                <div>
                  <h3>Parent Information</h3>
                  <p><strong>Parent Name:</strong> {currentStudent.parentName}</p>
                  <p><strong>Parent Mobile:</strong> {currentStudent.parentMobile}</p>
                </div>
                <div>
                  <h3>Other Information</h3>
                  <p><strong>Enquiry Source:</strong> {currentStudent.enquirySource}</p>
                  <p><strong>Counselor:</strong> {currentStudent.counselor}</p>
                  <p><strong>Internship ID:</strong> {currentStudent.internshipId}</p>
                  <p><strong>Remark:</strong> {currentStudent.remark}</p>
                </div>
              </div>
            )}
          </DialogContent>
          <DialogActions>
            <Button onClick={handleCloseDialog}>Close</Button>
          </DialogActions>
        </Dialog>

        <Snackbar
          open={snackbarOpen}
          autoHideDuration={6000}
          onClose={handleCloseSnackbar}
          anchorOrigin={{ vertical: 'top', horizontal: 'right' }}
        >
          <Alert onClose={handleCloseSnackbar} severity={snackbarSeverity}>
            {snackbarMessage}
          </Alert>
        </Snackbar>
      </div>
    </LocalizationProvider>
  );
};

export default StudentDetails;