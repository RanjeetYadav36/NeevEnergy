import React, { useEffect, useState,useRef } from "react"
import { Card, Row, Col, Button} from 'antd';
import { Select } from 'antd';
import "./neev-csv.css"
import {NavLink} from "react-router-dom"
import {Header} from "../header"
import axios from "axios"
import { FakeData } from "./fake-data";
import ReactToPrint from 'react-to-print';



export const NeevCsv = ()=> {
  const [data , setdata] = useState([])
  const [districtName, setDistrictName]=useState([])
  const[blockName,setBlockName] = useState([])
  const[gpName,setGpName] = useState([])
  const[clusterName,setClusterName] = useState([])
  const printRef = useRef()
const[img , setImg] = useState([])
  const [districtValue, setDistrictValue] = useState("")
  const [blockNameValue, setBlockNameValue] = useState("")
  const[gpValue , setGpValue] = useState("")
  const[clusterNameValue, setClusterNameValue] = useState("")
  // const a = () =>{
  //   const temp=data
  //     .map((i) => i.districtName)
  //     .filter((i, index, arr) => arr.indexOf(i) === index)
  //     setDistrictName(temp)
  // }



useEffect(()=>{
axios.get("http://localhost:8080/api/csv/csvall").then((res)=> 
{
  setdata(res.data)
  setDistrictName(res.data
    .map((i) => i.districtName)
    .filter((i, index, arr) => arr.indexOf(i) === index))
    console.log(districtName,"dsd")
// }  console.log(di,"sdsd")
}

// console.log("dataaaa",res.data)
)
},[])


useEffect(()=>{
block()
},[districtValue])

const block = () => {
  if(districtValue){
    const temp = data.filter((i, index, arr) => i.districtName == districtValue)
console.log(temp,"53")
 // .filter((i, index, arr) =>
  //  console.log(i,"index") === index)
  const temp2 = Object.values(temp)
  console.log(temp2,"hello")
   
  const temp3 = temp2.map((i) => i.blockName).filter((i,index,arr) =>arr.indexOf(i) === index)
  setBlockName(temp3)
  console.log(temp3,"sasa")

  return temp3;

  }
 
};

useEffect(()=>{
gp()
},[blockNameValue])

const gp = ()=>{
  console.log(blockNameValue,"abc")
  console.log(blockName,"abcd")
  if(blockNameValue){

  const gpArea = data.filter((i,index,arr)=> i.blockName == blockNameValue)
console.log(gpArea,"gpArea")
  const gpArea2 = Object.values(gpArea)
  console.log(gpArea2,"gpArea2")
  const gpArea3 = gpArea2.map((i)=> i.gpName).filter((i,index,arr) =>arr.indexOf(i) === index)
  console.log(gpArea3,"gpArea3")
  setGpName(gpArea3)
return gpArea3;
  }
}


useEffect(()=>{
  cluster()
  },[blockNameValue])


const cluster = ()=>{

  if(blockNameValue){
    const temp = data.filter((i, index, arr) => i.blockName == blockNameValue)
console.log(temp,"99")
 // .filter((i, index, arr) =>
  //  console.log(i,"index") === index)
  const temp2 = Object.values(temp)
  console.log(temp2,"hello")
   
  const temp3 = temp2.map((i) => i.clusterName).filter((i,index,arr) =>arr.indexOf(i) === index)
//   if(blockNameValue){

//   const clusterArea = data.filter((i,index,arr)=> i.blockName = blockNameValue)
// console.log(clusterArea,"54")
//   const clusterArea2 = Object.value(clusterArea)
//   const clusterArea3 = clusterArea2.map((i)=> i.clusterName).filter((i,index,arr) =>arr.indexOf(i) === index)

  setClusterName(temp3)
  return(temp3);
  }
}






useEffect(()=>{
  axios.get("http://localhost:8080/api/csv/csvall").then((res)=> 
  {
    setdata(res.data)
    console.log(res.data, "dsaqw")
    setDistrictName(res.data
      .map((i) => i.districtName)
      .filter((i, index, arr) => arr.indexOf(i) === index))
      console.log(districtName,"dsd")
  // }  console.log(di,"sdsd")
  }
  
  // console.log("dataaaa",res.data)
  )
  },[])



//   const city = 'Cuttack';
// const block = 'Tigiria';
// const district = null;
// const village = 'Tigiria Nazigarh,Gp-Nizigarh';

// const url = `http://localhost:8080/api/csvf/${city}/${block}/${district}/${encodeURI(village)}`;

// axios.get(url)
//   .then(response => {
//     console.log(response.data);
//   })
//   .catch(error => {
//     console.log(error);
//   });



const city = districtValue;
const block1 = blockNameValue;
const district = gpName;
const village = clusterNameValue;
console.log(village,"village")
const rework = village.replace("%20"," ")
console.log(rework,"rework")
  

// const url = `http://localhost:8080/api/csvf/${encodeURIComponent(city)}/${encodeURIComponent(block)}/${encodeURIComponent(district)}/${encodeURIComponent(village)}`;

const url = `http://localhost:8080/api/csv/csvf/${city}/${block1}/${district}/${village}`;
console.log(url,"url")

const handleSubmit =()=>{
axios.get(url)
  .then(res => {
        setImg(res.data.lighimage)
    console.log(res.data.lighimage);
  })
  .catch(error => {
    console.log(error);
  });
}

// const handleSubmit = ()=>{
//   axios.get(URL+${encodeURIComponent(districtValue)}+"/"+blockNameValue+"/"+gpValue+"/"+clusterNameValue).then((res)=>{
//     setImg(res.data)
//     console.log(res.data,"0000")
//   })
// }


const onChange = (event) => {
  const value = event.target.value;
  setDistrictValue(value);
block()
  
};

const onBlockChange = (event) => {
  const value = event.target.value;
  setBlockNameValue(value);
  console.log(value,"123456")
  gp()
  cluster()

};


const onGpChange = (event)=>{
  const value = event.target.value;
  setGpValue(value);
}

const onClusterChange = (event)=>{
  const value = event.target.value;
  console.log(value,"172")
  setClusterNameValue(value);
}



const imagePrint = ()=>{
  return(
    // <Card>
    <div >
    <Col span={12}  className="displayimg">
    {img.map((img)=>{
            return(
            <img src={img} style={{height:"400px" , width:"400px"}} />
            )
          })}
    </Col>
    </div>
  )
}


console.log(districtValue,"fefefefe")

  const onDistrictName =()=>{
    
    return(
      <select
      // onChange={(value)=>setDistrictValue(value)
      onChange ={onChange}
      style={{ width: 120, height:30 }}

      defaultValue =""
      name ="districtName"
      >
        <option>Select</option>

      {districtName.map((item)=>{
       return(
       <option value={item}>{item}</option>
       )
      })}
      </select> 
//  <Select
//     //  labelSubName= "District Name"
//      placeholder="select"
//      name="districtName"
//       value = "xyz"
//       style={{ width: 120 }}
      // onChange={onDistrictChange}

    //   {districtName.map((item, i) => {
    //     return (
    //         <option value={item}>{item}</option>
    //     )
    // })}
      // options={
      //   districtName.map((item, i) => {
      //     return (
      //       <option value={item}>{item}</option>

      //     )
      // })
      //   [ 
      //   { value: 'Khorda', label: 'Khorda' },
      //   { value: 'Ganjam', label: 'Ganjam' },
      //   { value: 'Cuttack', label: 'Cuttack' },
      // ]
    // }
    // />
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
        {onDistrictName()}
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
        <p  className="districtNameBox">Block Name</p>
        <select
      // onChange={(value)=>setDistrictValue(value)
      onChange ={onBlockChange}
      style={{ width: 120, height:50 }}

      defaultValue = ""
      name ="blockName"
      >
<option value = "">Select</option>
      {blockName.map((item)=>{
        console.log(item,"1234")
       return(
        
              //  <option value={"hello"}>{"hello"}</option>

       <option value={item}>{item}</option>
       )
      })}
      </select> 
{/* <Select
      defaultValue="lucy"
      style={{ width: 120 }}
      onChange={handleChange}
      options={[
        { value: 'Khorda', label: 'Khorda' },
        { value: 'Ganjam', label: 'Ganjam' },
        { value: 'Cuttack', label: 'Cuttack' },
      ]}
    /> */}
        </Col>

        <Col span={6}>
        <p className="districtNameBox">GP Name</p>
        <select
         style={{ width: 120, height:30 }}

      // onChange={(value)=>setDistrictValue(value)
      onChange ={onGpChange}
        
      defaultValue = ""
      name ="gpName"
      >
        <option value = "" >Select</option>

      {gpName.map((item)=>{
      return(
       <option value={item}>{item}</option>
       )
      })}
      </select> 

{/* <Select
    //   defaultValue="lucy"
      style={{ width: 120 }}
    //   onChange={handleChange}
      options={[
        { value: 'Khorda', label: 'Khorda' },
        { value: 'Ganjam', label: 'Ganjam' },
        { value: 'Cuttack', label: 'Cuttack' },
      ]}
    /> */}
        </Col>

        <Col span={6}>
        <p className="districtNameBox">Cluster Name</p>

        <select
      // onChange={(value)=>setDistrictValue(value)
      onChange ={onClusterChange}
      style={{ width: 120, height:30 }}

      defaultValue = ""
      name ="clusterName"
      >
        <option value = "" >Select</option>
      {clusterName.map((item)=>{
      return(
       <option value={item}>{item}</option>
       )
      })}
      </select> 
{/* <Select
      defaultValue="lucy"
      style={{ width: 120 }}
      onChange={handleChange}
      options={[
        { value: 'Khorda', label: 'Khorda' },
        { value: 'Ganjam', label: 'Ganjam' },
        { value: 'Cuttack', label: 'Cuttack' },
      ]}
    /> */}
        </Col>
    
    </Row>
<Row>
<Col span={24} className="submitBtn">
        <Button className="submit"
        onClick = {handleSubmit}
        >Submit</Button>

        </Col>


      
</Row>

     
      </Card>
      <Card>
      <Row>
          <div>
      
      <div ref={printRef} className="print-only">
        {/* <PrintComponent /> */}
        <p className="clusterValue">{clusterNameValue}</p>

        {imagePrint()}
      </div>
      <ReactToPrint
        trigger={() => <button>Print</button>}
        content={() => printRef.current}
      />
    </div>
          
        </Row>
        </Card>


  </div>
  )
}


// axios.get({ params: { districtName: {distrciValue}, clusterName: {clusterNameValue} , blockName:{blockNameValue}} })