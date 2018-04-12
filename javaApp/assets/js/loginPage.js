class Login extends React.PureComponent {
	render() {
		return (
			
			<div>
				<div className="header">
					<font className = "fc">Java</font>
					<font className = "fd">Login</font>
					<div className="dropdown">
						<button className="dropbtn"><img className="button-image1" src="/Asset/assets/?file=guest.png"/ ><p id="user1">Guest</p></button>
						<div className="dropdown-content">
							<a href="/Program/index/?order=ASC">
							<img className="loghistory-img" src="/Asset/assets/?file=home.png" alt="Home" /><pre id="log-his">Home</pre></a>
						</div>
					</div>
				</div>
			 
			<div className = "container">	
				<form id="form" action="/User/validation/?">
					<center>
						USERNAME: <input type="text" placeholder="Enter Username" name = "name" required /><br /><br /> 
						PASSWORD: <input type="password" placeholder="Enter Password" name = "password" required /><br /><br />
						<input type="hidden" name="input" value="INPUT" />
						<button id="login" type="submit">Login</button>
				
				<a href="/User/signup/signUp"><button id="signup" type="submit">SignUp</button></a>
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
						<a href = "https://www.linkedin.com/feed/" target = "_blank"><img className="footer-img" src = "/Asset/assets/?file=linkendin.png" /></a>
					</div>
				</div>
		</div>
		
	</div>	
		
		);
	
	
	}

}
ReactDOM.render(
  <Login />,
  document.getElementById('wrapper')
);
