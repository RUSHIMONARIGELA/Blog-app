import React from "react";
import { useLoaderData, useNavigate } from "react-router-dom";
import Markdown from 'react-markdown'
import axios from "axios";

export default function BlogItem() {
  const allBlogs = useLoaderData();
  const navigate=useNavigate()
  console.log(allBlogs);
  const deleteBlog=async(id)=>{
    await axios.delete(`http://localhost:8080/blog/${id}`)
    navigate("/ ")



  }

  return (
    <>
      {allBlogs.map((blog, index) => {
        return (
        <div  key ={index} className="card shadow p-3 mb-5 rounded border-0">
          <div className="card-body">
            <h5 className="card-title">{blog.title}</h5>
            <p className="card-text">
              <Markdown>{blog.description}</Markdown> </p>
            <p><a href={`/blogView/${blog.id}`} >
              View More
            </a></p>
            <button onClick={()=>deleteBlog(blog.id)} className="btn btn-danger">Delete</button>
          </div>
        </div> )
      })}
    </>
  );
}
