import { DialogContent, DialogTitle, Dialog } from '@mui/material';
import React, {useState, useEffect} from 'react';
import { Paper, TextField, Button, Box, Alert } from '@mui/material';



export default function Popup(props) {
    const paperStyle = {
        padding: '10px 22px',
        width: 300,
        margin: '10px 5px 20px 5px'
    }

    const { title, chidren, openPopup, setOpenPopup } = props;

    const [name, setName] = useState('');
    const [location, setLocation] = useState('');

    const [alert, setAlert] = useState(false);
    const [alertContent, setAlertContent] = useState('');
    const [severity, setSeveryty] = useState('success');
    const [showElement, setShowElement] = useState(false);

    useEffect(() => {
        setTimeout(function () {
            setShowElement(false)
        }, 60000);
    })

    const handleUpdate = (title) => {
        const author = {name, location }

        fetch(`http://localhost:8080/authors/${title.id}`, {
            method: "PUT",
            headers: { "Content-Type": "application/json" },
            body: JSON.stringify(author)
        }).then((response) => {
            if (response.ok) {
                setAlertContent('Saved complite');
                setShowElement(true);
                setAlert(true);

            } else {
                setAlertContent('Not saved');
                setAlert(true);
                setShowElement(true);
                setSeveryty('error');
            }

        }).then(() => setOpenPopup(false))
    }
    

    return (
        <Dialog open={openPopup}>
            <DialogTitle>
                <div style={{ margin: "5px auto", textAlign: 'center' }}>Update author</div>
            </DialogTitle>
            <DialogContent dividers>
                <Paper elevation={3} style={paperStyle}>
                    <Box
                        component="form"
                        sx={{
                            '& > :not(style)': { m: 1 },
                        }}
                        noValidate
                        autoComplete="off"
                    >
                        <TextField className='textFields' id="outlined-basic" label="Id" variant="outlined"
                            value={title.id}
                            fullWidth InputProps={{
                                readOnly: true,
                            }} />
                        <TextField className='textFields' id="outlined-basic" label="Name" variant="outlined"
                            value={name}
                            onChange={(e) => setName(e.target.value)}
                            fullWidth />
                        <TextField className='textFields' id="outlined-basic" label="Location" variant="outlined" 
                            value={location}
                            onChange={(e) => setLocation(e.target.value)}
                            fullWidth />
                    </Box>
                </Paper>
                <div style={{ margin: "5px auto" }}>
                    <Button style={{ margin: "auto 10px auto 80px" }} type="submit" size="medium" variant="contained"
                    onClick={() => handleUpdate(title)}
                    >Update</Button>
                    <Button style={{ margin: 10 }} type="submit" size="medium" variant="contained" color="warning" 
                    onClick={() => setOpenPopup(false)}
                    >Close</Button>
                </div>
                <div>
                    {alert & showElement ? <Alert severity={severity}>{alertContent}</Alert> : <></>}
                </div>
            </DialogContent>
        </Dialog>
    )
}
