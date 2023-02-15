import React, { useEffect, useState } from "react"
import { Card, Row, Col, Button} from 'antd';
import { Select } from 'antd';
import "./neev-csv.css"
import {NavLink} from "react-router-dom"
import {Header} from "../header"
import axios from "axios"
import { FakeData } from "./fake-data";


export const NeevCsv = ()=> {
  const [districtValue, setDistrictValue] = useState([])
  const [districtID, setDistrictID] = useState([])
    

useEffect(()=>{
axios.get("http://192.168.1.84:8080/api/csv/csvall").then((res)=>
console.log("dataaaa",res.data)
)
},[])



  const onDistrictChange = (value)=>{
    setDistrictValue({
      ...districtValue,
      ["district"] : value,
    });
  }

  const onDistrictName =()=>{
    return(
<Select
     labelSubName= "District Name"
     placeholder="select"
     name="districtName"
     rules={[
      {
          required: true,
          message: "Please enter your District Name",
      },
  ]}

      value ={onDistrictName?.districtName}
      style={{ width: 120 }}
      onChange={onDistrictChan

      {districtID.map((districtName, i) => {
        return (
            <option value={districtName}>{districtName}</option>
        )
    })}
      // options={[
      //   { value: 'Khorda', label: 'Khorda' },
      //   { value: 'Ganjam', label: 'Ganjam' },
      //   { value: 'Cuttack', label: 'Cuttack' },
      // ]}
    />
    )
  }

  return(  
    


    

  <div className="neevCsv">
    <Header />
     {/* <div>
    <ul className = "headerList">
    <li> <Link to="/csv">Home</Link></li>
    <li> <Link to ="/file">About Us</Link></li>
    <li>Contact Us</li>
    </ul>
    
    </div> */}
  <Card className="neevCsvCard">
    <Row>
        <Col span={6}>
        <p className="districtNameBox">District Name</p>
        {onDistrictName}
{/* <Select
     labelSubName= "District Name"
     placeholder="select"
     name="districtName"
     rules={[
      {
          required: true,
          message: "Please enter your District Name",
      },
  ]}

    //   defaultValue="lucy"
      style={{ width: 120 }}
      onChange={onDistrictChange}
      options={[
        { value: 'Khorda', label: 'Khorda' },
        { value: 'Ganjam', label: 'Ganjam' },
        { value: 'Cuttack', label: 'Cuttack' },
      ]}
    /> */}
        </Col>
        <Col span={6}>
        <p className="districtNameBox">Block Name</p>
<Select
    //   defaultValue="lucy"
      style={{ width: 120 }}
    //   onChange={handleChange}
      options={[
        { value: 'Khorda', label: 'Khorda' },
        { value: 'Ganjam', label: 'Ganjam' },
        { value: 'Cuttack', label: 'Cuttack' },
      ]}
    />
        </Col>

        <Col span={6}>
        <p className="districtNameBox">GP Name</p>
<Select
    //   defaultValue="lucy"
      style={{ width: 120 }}
    //   onChange={handleChange}
      options={[
        { value: 'Khorda', label: 'Khorda' },
        { value: 'Ganjam', label: 'Ganjam' },
        { value: 'Cuttack', label: 'Cuttack' },
      ]}
    />
        </Col>

        <Col span={6}>
        <p className="districtNameBox">Cluster Name</p>
<Select
    //   defaultValue="lucy"
      style={{ width: 120 }}
    //   onChange={handleChange}
      options={[
        { value: 'Khorda', label: 'Khorda' },
        { value: 'Ganjam', label: 'Ganjam' },
        { value: 'Cuttack', label: 'Cuttack' },
      ]}
    />
        </Col>
    
    </Row>
<Row>
<Col span={24} className="submitBtn">
        <Button className="submit">Submit</Button>

        </Col>
</Row>

      </Card>

  </div>
  )
}