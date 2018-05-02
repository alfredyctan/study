//import Test from './welcome.js';


//function Welcome(props) {
//  return <h1>Hello, {props.name}</h1>;
//}


//var test = new Test();
//test.present();

class Welcome extends React.Component {
	render() {
		let _this = this.props;
		return <div style={{width: '100%', height: '400px'}}><h1>Hello, {_this.name}</h1></div>;
	}
}

class Clock extends React.Component {

	constructor(props) {
		super(props);
		var esto = this;
		this.state = {
			date: new Date(),
			count: 0,
			interval: props.interval,
			increment: function () {
				console.log('increment');
				return esto.state.count++;
			}
		};
	}

	componentDidMount() {
		console.log("mount : " + this.state.interval);
		this.timerID = setInterval(
			() => this.tick(),
			this.state.interval
		);

		this.counterID = setInterval(
			() => this.increment(),
			0.5 * this.state.interval
		);
	}
	
	componentWillUnmount() {
		clearInterval(this.timerID);
		clearInterval(this.counterID);
	}

	render() {
		// let _this = this.props;
		return <h2>It is {this.state.date.toLocaleTimeString()} - {this.state.count}.</h2>;
	}

	tick() {
		this.setState(
			(oState, props) => ({
				date: new Date()
			})
		);
	}
	
	increment() {
		this.setState(
			(oState, props) => ({
				count: oState.count + 1
			})
		);
	}
}

class Toggle extends React.Component {
	constructor(props) {
		super(props);
		this.state = { isToggleOn: true };

		// This binding is necessary to make `this` work in the callback
		this.handleClick = this.handleClick.bind(this);
	}

	handleClick() {
		this.setState(prevState => ({
			isToggleOn: !prevState.isToggleOn
		}));
	}

	render() {
		return (
			<button onClick={this.handleClick}>
				{this.state.isToggleOn ? 'ON' : 'OFF'}
			</button>
		);
	}
}

class Panel extends React.Component {

	componentDidMount() {
	}

	render() {
		let _this = this.props;
		return (
			<div style={{width: '100%', height: '400px'}}>
				<iframe style={{width: '100%', height: '400px'}} src={_this.url}></iframe>
			</div>
		);
	}
}

class PanelContainer extends React.Component {

	render() {
		let _this = this.props;
		return (
			<div>
				<Welcome id="poc" name="POC" />
				<Panel id="oms" name="OMS" url="http://fiximate.fixtrading.org" />
				<Panel id="lcm" name="LCM" url="http://en.wikipedia.org" />
			</div>
		);
	}
}

ReactDOM.render(
	<PanelContainer />,
	document.getElementById('main')
);

setInterval(
	function () {
		ReactDOM.render(
			<span><Toggle /><Clock interval="1000" /></span>,
			document.getElementById('status')
		);
	},
	1000
);

class Button extends React.Component {

	onButtonClick(e) {
		console.log('The poc button was clicked. ' + e);
	}


	render() {
		let _this = this.props;
		return <button className="btn" onClick={this.onButtonClick}>{_this.name}</button>;
	}
}


class Button2 extends React.Component {

	render() {
		let _this = this.props;
		console.log('The button render. ' + _this.listener);
		return <button className="btn" onClick={_this.listener}>{_this.name}</button>;
	}
}

function onButtonClickOMS(e) {
	console.log('The OMS button was clicked. ' + e);
}

function onButtonClickLCM(e) {
	console.log('The LCM button was clicked. ' + e);
}

class Menu extends React.Component {
	render() {
		let _this = this.props;
		return (
			<div>
				<Button name="POC" />
				<Button2 name="OMS" listener={onButtonClickOMS} />
				<Button2 name="LCM" listener={onButtonClickLCM} />
			</div>
		);
	}
}

ReactDOM.render(
	<Menu />,
	document.getElementById('menu')
);
