class AddProgram extends React.PureComponent {
	
	render() {
			
			return (
				
				<div>
					<div className="header">
						<font className = "fc">Java</font>
						<font className = "fd">ADD PROGRAMS</font>
						<div className="dropdown">
							<button className="dropbtn" /* onclick="document.getElementById('myModal').style.display='block';" style="width:auto;" */><img className="header-img" src="/Asset/assets/?file=guest.png" /><a href = "/users/edit"><p id="user">Guest</p></a></button>
							<div className="dropdown-content">
								<a href="/Program/index/?order=ASC">
								<img className="loghistory-img" src="/Asset/assets/?file=back.jpg" alt="Back" /><pre id="log-his">Home</pre></a>
							
								<a href="/Mail/contactUs">
								<img className="loghistory-img" src="/Asset/assets/?file=contact.png" alt="Contact" /><pre id="log-his">Contact</pre></a>
							
								<a href="/User/logout/logout">
								<img className="loghistory-img" src="/Asset/assets/?file=logout.jpg" alt="Logout" /><pre id="log-his">Logout</pre></a>
							</div>
						</div>
					</div>
					<div className="container">
						<form action="/Program/create/?">
							<center>
								<pre id="label2">Program Name:</pre>
								<input id="add" type="text" name="programname" placeholder="please enter the program name" /><br />
								<pre id ="label2">Program Description:</pre>
								<textarea id ="des"  name = "description" placeholder="please enter the description"></textarea><br /><br /><br /><br />
								<pre id ="label2">Program Code:</pre>
								<textarea id = "des"  name = "code" placeholder="please write the code"></textarea><br /><br />
								<button id="button" type="submit" onload="showMessage()">Submit</button>
							</center>
						</form>
					</div>
					<div className="footer">
						<p id="top">Ananth Kumar  Copyright&copy;2017</p>
						<br />
						<p id="move"></p>
						<div className="move-right">
							<div id="move-top">
								<a href = "https://www.facebook.com/cananthkumar" target = "_blank"><img className="footer-img" src = "/Asset/assets/?file=facebook.png" /></a>
								<a href = "https://plus.google.com/u/0/" target = "_blank"><img className="footer-img" src = "/Asset/assets/?file=googleplus.png" /></a>
								<a href = "https://www.linkedin.com/feed/" target = "_blank"><img className="footer-img" src = "/Asset/assets/?file=linkendin.png" /></a></div>
							</div>
						</div>			
				</div>	
			);
	}	
}
ReactDOM.render(
  <AddProgram />,
  document.getElementById('wrapper')
);
