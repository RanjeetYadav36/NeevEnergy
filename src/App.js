import logo from './logo.svg';
import './App.css';
import { Header } from './header';
import { NeevCsv } from './Body/neev-csv';
import { Link } from 'react-router-dom';
import {NeevFile}  from './Body/neev-file';
import {
  BrowserRouter,
Route,
  Routes,
} from "react-router-dom";




function App() {
  return (
   <>
     <BrowserRouter>
    <Routes>
     <Route
        path= "/csv"
       element= {<NeevCsv />}
      />,
      <Route
        path= "/file"
       element= {<NeevFile />}
      />
  

    </Routes>
    
    </BrowserRouter>
   
   </>

  
  );
}

export default App;
