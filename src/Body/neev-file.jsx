import React from "react"
import {Card} from "antd";
import {Header} from "../header"
import { Button, Upload } from 'antd';
import { UploadOutlined } from '@ant-design/icons';




export const NeevFile = ()=>{

    // const props = {
    //     name: 'file',
    //     action: 'https://www.mocky.io/v2/5cc8019d300000980a055e76',
    //     headers: {
    //       authorization: 'authorization-text',
    //     }

    return(
<div>
    <Header />
<Card>

<form action="/action_page.php">
  <input type="file" id="myFile" name="filename" value = "filename"></input>
  <Button type="submit">Submit</Button>
</form>

</Card>

</div>
    )
}