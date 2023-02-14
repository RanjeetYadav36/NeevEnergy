import { NeevCsv } from "../Body/neev-csv";
import {
    BrowserRouter,
    createBrowserRouter,
    RouterProvider,
  } from "react-router-dom";
// import { NeevFile } from "../Body/neev-file";

  export const Router  = ()=>{
return(
    <BrowserRouter>
    <Routes>
     <Route
        path= "/csv"
       element= {<NeevCsv />}
      />,
      <Route
        path= "/file"
       element= {<NeevCsv />}
      />
  

    </Routes>
    
    </BrowserRouter>
)

  }
   
   
  