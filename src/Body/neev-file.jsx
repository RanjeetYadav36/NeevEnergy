import React from "react"
import {Card} from "antd";
import {Header} from "../header"
import "./neev-file.css"
import { Button, Upload , Form, Col} from 'antd';
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
<Form>

<Col md={12} lg={7} xl={6}>
                  <Form.Item name="uploadFile"
                  rules={[
                    {
                      required: true,
                      message: "Please Select a File.",
                    },
                  ]}>
                  <div className="browseBtn slice">
                  {/* {urlUpload?.name ?<span>{urlUpload?.name}</span>:<span style={{color:'#ddd'}}> */}
                    {/* You can only upload .xlxs file! */}
                    {/* </span>} */}
                    </div>
                    </Form.Item>
                    </Col>
                    <Col md={14} lg={0} xl={0} ></Col>
                    <Col  md={5} xl={3} lg={3} xxl={3} style={{textAlign:'center'}}>
                    <Form.Item name="uploadFile"
                  rules={[
                    {
                      required: true,
                      message: "",
                    },
                  ]}>

                    <Upload
                      name="uploadFile"
                      className="importUpload"
                    //   beforeUpload={handleBeforeUpload}
                      maxCount={1}
                      openFileDialogOnClick={true}
                    //   onChange={handleUpload}
                    //   showUploadList={false}
                    >
                      <div className="primary browser">Browse</div>
                    </Upload>
                </Form.Item>
                </Col>
                    <Col md={5} lg={6} xl={3}>
                      <Button type="primary" htmlType="submit" form="importUsers">
                        submit
                      </Button>
                    </Col>
</Form>
</Card>

</div>
    )
}