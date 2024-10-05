import axios from 'axios'
import React, { useState } from 'react'
import { useNavigate } from 'react-router-dom'

export default function AddBlog() {
   const [blogData,setBlogData]=useState({})
   const navigate=useNavigate()

   const onHandleChange=(e)=>{
       setBlogData(pre=>({...pre,[e.target.name]:e.target.value}))

   }
   const onSubmit=async(e)=>{
    e.preventDefault()
    await axios.post("http://localhost:8080/blog",blogData)
    navigate("/")
   }


  return (
   <>
   <div className="container mt-5" >
    <div className="row">
        <div className="col-md-8 offset-md-2">
        <form>
  <div class="mb-3">
    <label for="title" class="form-label">Title</label>
    <input type="text" name="title" class="form-control" onChange={onHandleChange} />
  </div>
  <div class="mb-3">
    <label for="description" class="form-label">Description</label>
    <textarea type="text" name="description"rows="10"  class="form-control" onChange={onHandleChange} ></textarea>
  </div>

  <div className="text-center">  <button onClick={onSubmit} type="submit" class="btn btn-success">Submit</button>
  </div>
</form>
        </div>
    </div>
   </div>
   

   </>
  )
}
