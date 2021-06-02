using System.Net.Http;
using Microsoft.AspNetCore.Mvc;

namespace WebApplication.Controllers
{
    [ApiController]
    [Route("[controller]")]
    public class PostController : ControllerBase
    {
        private string Uri = "https://jsonplaceholder.typicode.com";
        // GET
        [HttpGet]
        public string GetPost()
        {
            // HttpClient client = new HttpClient();
            return new HttpClient().GetAsync(Uri + "/posts").Result
                .Content
                .ReadAsStringAsync()
                .Result;
            
        }
        
        [HttpGet("{id}")]
        public string GetPostWithSpecificId(int id)
        {
            return new HttpClient().GetAsync(Uri + "/posts/" +id).Result
                .Content
                .ReadAsStringAsync()
                .Result;
        }
    }
}