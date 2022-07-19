import React, { useEffect, useState } from 'react';
import { Container } from '@mui/system';
import { Paper, Button, Alert, Box, TextField } from '@mui/material';
import { createTheme, ThemeProvider } from '@mui/material/styles';
import Typography from '@mui/material/Typography';

const theme = createTheme({
    typography: {
        fontFamily: [
            'Kaushan Script',
            'cursive'
        ].join(','),
    },
    color: '#888'
});

export default function AuthorNew() {
    const paperStyle = {
        padding: '10px 20px',
        width: 600,
        margin: '30px auto'
    }

    const h2Style = {
        color: '#888',
        fontSize: 23,
        fontWeight: 400
    }

    const [name, setName] = useState('');
    const [location, setLocation] = useState('');

    const [alert, setAlert] = useState(false);
    const [alertContent, setAlertContent] = useState('');

    const [severity, setSeveryty] = useState('success');
    const [showElement, setShowElement] = useState(false);

    useEffect(() => {
        setTimeout(function () {
            setShowElement(false)
        }, 6000);
    })

    const handleClick = (e) => {
        e.preventDefault()
        const author = { name, location }
        fetch("http://localhost:8080/authors", {
            method: "POST",
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

        }).catch(error => {
            alert(error)
        })
    }

    return (
        <Container>

            <Paper elevation={3} style={paperStyle}>
                <ThemeProvider theme={theme}>
                    <Typography component="div">
                        <h2 style={h2Style}>Create author</h2>
                    </Typography>
                </ThemeProvider>
                <Box
                    component="form"
                    sx={{
                        '& > :not(style)': { m: 1 },
                    }}
                    noValidate
                    autoComplete="off"
                >
                    <TextField id="outlined-basic" label="Author Name" variant="outlined" fullWidth
                        value={name}
                        onChange={(e) => setName(e.target.value)}
                    />
                    <TextField id="outlined-basic" label="Author Location" variant="outlined" fullWidth
                        value={location}
                        onChange={(e) => setLocation(e.target.value)}
                    />
                </Box>

                <div>
                    {alert & showElement ? <Alert severity={severity}>{alertContent}</Alert> : <></>}
                </div>

                <Button style={{ margin: 20 }} type="submit" size="medium" variant="contained" onClick={handleClick}>SAVE</Button>
            </Paper>

        </Container>

    );
}
