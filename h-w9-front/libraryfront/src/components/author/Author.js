import React, { useEffect, useState } from 'react';
import { Container } from '@mui/system';
import { Paper, Button, Grid } from '@mui/material';
import { ForkRight } from '@mui/icons-material';
import { createTheme, ThemeProvider } from '@mui/material/styles';
import Typography from '@mui/material/Typography';
import axios from 'axios';
import Popup from './Popup';

const theme = createTheme({
    typography: {
        fontFamily: [
            'Kaushan Script',
            'cursive'
        ].join(','),
    },
    color: '#888'
});



export default function Author() {
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

    const [authors, setAuthors] = useState([]);
    const [alert, setAlert] = useState(1);
    const [openPopup, setOpenPopup] = useState(false);

    const [authorId, setAuthorId] = useState('');


    const onDelete = (id) => {
        axios.delete(`http://localhost:8080/authors/${id}`)
            .then(() => {
                setAlert(alert + 1);
            })
    }

    useEffect(() => {
        fetch("http://localhost:8080/authors")
            .then(res => res.json())
            .then((result) => {
                setAuthors(result);
            }
            )
    }, [alert])//using alert to automatical update after delete

    return (
        <Container>


            <Paper elevation={3} style={paperStyle}>
                <ThemeProvider theme={theme}>
                    <Typography component={'span'}>
                        <span>
                            <h2 style={h2Style}>Authors</h2>
                        </span>
                    </Typography>
                </ThemeProvider>

                {authors.map(author => (
                    <Paper elevation={6} style={{ margin: "10px", padding: "15px", textAlign: "left" }} key={author.id}>
                        <Grid container spacing={2}>
                            <Grid item xs={7}>
                                Id : {author.id}<br />
                                Name : {author.name}<br />
                                Location : {author.location}
                            </Grid>
                            <Grid item xs={2}>
                                <Button style={{ margin: 20, alignContent: ForkRight }}
                                    color="secondary"
                                    size="medium"
                                    variant="outlined"
                                    c
                                    onClick={(e) => {
                                        setOpenPopup(true);
                                        setAuthorId(author);
                                    }}
                                >Update
                                </Button>
                                <Popup
                                    title={authorId}
                                    openPopup={openPopup}
                                    setOpenPopup={setOpenPopup}
                                >
                                </Popup>

                            </Grid>
                            <Grid item xs={2}>
                                <Button style={{ margin: 20, alignContent: ForkRight }}
                                    color="warning"
                                    size="medium"
                                    variant="outlined"
                                    onClick={() => onDelete(author.id)}
                                >Delete
                                </Button>
                            </Grid>

                        </Grid>
                    </Paper>
                ))}
            </Paper>



        </Container >


    );
}
