//import Test from './welcome.js';


//function Welcome(props) {
//  return <h1>Hello, {props.name}</h1>;
//}


//var test = new Test();
//test.present();

class Welcome extends React.Component {
	render() {
		let _this = this.props;
		return <h1>Hello, {_this.name}</h1>;
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
		//return <h2>It is {this.state.date.toLocaleTimeString()} - {this.state.increment()}.</h2>;
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

class Everything extends React.Component {

	render() {
		let _this = this.props;
		return (
			<span>
				<Welcome name="Sara" />
				<Clock interval="1000" />
				<Clock interval="2000" />
				<Clock interval="3000" />
			</span>
		);
	}
}

setInterval(
	function () {
		ReactDOM.render(
			<Everything />,
			document.getElementById('main')
		);
	},
	1000
);

