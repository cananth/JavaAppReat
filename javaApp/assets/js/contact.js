class Contact extends React.Component {
	render() {
		return (
			<div>
				<div className="header">
					<font className = "fc">Java</font>
					<font className = "fd">List of Programs</font>
					<div className="dropdown">
						<button className="dropbtn"><a href="/"><img className="header-img" src = "/Asset/assets/?file=guest.png" alt="Guest" width="30" height="30"/></a><p id="user4">{this.state.username}</p></button>
							<div className="dropdown-content">
								<a href="/User/login/login">
									<img className="header-img2" src = "/Asset/assets/?file=login.png" alt="Login" /><pre id="head-button">Login</pre></a>						
								<a href="/Mail/contactUs/contact">
									<img className="header-img1" src = "/Asset/assets/?file=contact.png" alt="Contact" /><pre id="head-button">Contact</pre></a>						
								<a href="/User/signup/signup">
									<img className="header-img4" src = "/Asset/assets/?file=signup.png" alt="Signup" /><pre id="head-button">Signup</pre></a>						
							</div>
					</div>
				</div>
			</div>	
		);			
	}
}
ReactDOM.render(
  <Contact />,
  document.getElementById('root')
);
