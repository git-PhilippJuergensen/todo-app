import Container from '@mui/material/Container';
import Grid from '@mui/material/Grid';
import ToDoList from './component/ToDoList';

import './App.css';

function App() {
  return (
    <div className="App">
      <Container maxWidth="md">
        <h1>ToDo list</h1>
        <Grid item xs={12} md={6} xl={6}>
          <ToDoList/>
        </Grid>
      </Container>
      
    </div>
  );
}

export default App;
