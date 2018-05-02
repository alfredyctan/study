
function variables() {
	for (let blockLevelVariables = 0; blockLevelVariables < 10; blockLevelVariables++) {
		console.log(blockLevelVariables);
	}
	
	if (true) {
		var visible = 'yes';
	}
	console.log('visible expected is visible here : ' + visible)

	const constant = 1;
	constant = 0// throw error
}

function operators() {
	
	123 == '123'; // true
	1 == true; // true

	//with type check
	123 === '123'; // false
	1 === true;    // false
	
	123 !== '123'; // true
	1 !== true;    // true

}

function bitwise() {

	// Returns a 1 in each bit position for which the corresponding bits of both operands are 1's.
	var a = 9;    // 1001
	var b = 14;   // 1110
	var and = 8;  // 1000
	a & b == and;  

	var or = 15;  // 1111
	a | b == or;  
	
	var xor = 7;  // 0111
	a ^ b == xor;  

	//Inverts the bits of its operand.
	var not = -10; // 11 0110
	~ a == not;    
	
	//Shifts a in binary representation b (< 32) bits to the left, shifting in 0's from the right.
	var left = 36; // 100100
	a << 2 == left;

	////Shifts a in binary representation b (< 32) bits to the right, discarding bits shifted off.
	var right = 36; // 000010
	a >> 2 == right;

	//Shifts a in binary representation b (< 32) bits to the right, discarding bits shifted off, and shifting in 0's from the left.
	var a2 = -9                    // 11111111111111111111111111110111 
	var zeroFillRight = 1073741821 // 00111111111111111111111111111101 	
	a2 >>> 2 == zeroFillRight;
	
}

function structures() {
	for (let value of array) {
	  // do something with value
	}

	for (let property in object) {
	  // do something with object property
	}
	
	// will do null check on o before o.getName()
	var name = o && o.getName(); 
	
	// name will be assigned with cachedName if not null, else cachedName assigned with getName() and assigned to name
	var name = cachedName || (cachedName = getName()); 
}

function objects() {
	// empty object
	var obj = new Object();
	var obj = {}; // a empty json object
	
	
	var obj = {
		name: 'Carrot',
		_for: 'Max', // 'for' is a reserved word, use '_for' instead.
		details: {
			color: 'orange',
			size: 12
		}
	};
	obj.details.color;      // orange
	obj['details']['size']; // 12
	
	
	function Person(name, age) {
		this.name = name;
		this.age = age;
	}

	// Define an object
	var you = new Person('You', 24);
	obj.name = 'Simon';
	obj['name'] = 'Simon';
}

function arrays() {
	var a = new Array();
	a[0] = 'dog';
	a[1] = 'cat';
	a[2] = 'hen';
	
	a.length; // 3
	typeof a[90]; // undefined
	a[100] = 'fox';
	a.length; // 101
	
	for (const currentValue of a) {
	  // Do something with currentValue
	}
	
	var b = ['dog', 'cat', 'hen'];
	b.length; // 3
	
	
	// Array's forEach function
	['dog', 'cat', 'hen'].forEach(
		function(currentValue, index, array) {
			//Do something with currentValue or array[index]
		}
	);
	
	// append to array
	a.push('wolf', 'pig');
	
	// array useful function
	a.join(','); // create a string with , delimiter
	
	// removes and returns the last item.
	a.pop();
	
	// Reverses the array.
	a.reverse();

	// Removes and returns the first item.
	a.shift();
	
	
	// Returns a sub-array.
	a.slice(1, 2) // ['cat', 'hen']
	
	
	// sort with function
	a.sort(function (a, b) {
		
	});
	
	// Prepends items to the start of the array.
	a.unshift('rabbit', 'turtle'); 		
}

function testClassFromPrototypeObject() {

	function Person(first, last, age) {
		this.first = first;
		this.last = last;
		this.age = age;
		this.fullName = function() { // every object has function object 
			return this.first + ' ' + this.last;
		};
	}
	
	// object method defined on prototype(class) level
	Person.prototype.reverseFullName = function () {
		return this.last + ' ' + this.first;
	}
	
	// 'new' means create an empty object and assign the property from the function returned
	var withNew = new Person('alf', 'tan', 84);
	console.log(withNew.fullName());
	console.log(withNew.reverseFullName());

	withNew.gender = 'M';
	console.log(withNew.gender);
	
	
	// Define an object
	var withoutNew = Person('alf', 'tan', 84);
	console.log(withoutNew.fullName()); // undefine
}

function testClassFromJsonObject() {

	function Person(first, last, age) {
		return {
			first: first, // in json style, instead of this.first = first 
			last: last,
			age: age,
			fullName: function() {
				return first + ' ' + last;
			}
		};
	}

	// object method defined on prototype(class) level
	Person.prototype.reverseFullName = function () {
		return this.last + ' ' + this.first;
	}

	
	// Define an object
	var withNew = new Person('alf', 'tan', 84);
	console.log(withNew.gender);
	withNew.gender = 'M';
	console.log(withNew.fullName());
	console.log(withNew.gender);
//	console.log(withNew.reverseFullName()); // not a function

	// Define an object
	var withoutNew = Person('alf', 'tan', 84);
	console.log(withoutNew.gender);
	withoutNew.gender = 'M';
	console.log(withoutNew.fullName()); 
	console.log(withoutNew.gender);
//	console.log(withoutNew.reverseFullName()); // not a function

	// withoutNew2 is another new object Person
	var withoutNew2 = Person('alf2', 'tan2', 84);
	console.log("withoutNew2.fullName() " + withoutNew2.fullName()); 
	console.log("withoutNew2.gender " + withoutNew2.gender);

	console.log("withoutNew.fullName() " + withoutNew.fullName()); 
	console.log("withoutNew.gender " + withoutNew.gender);
}


function addFunctionToBuiltInObject() {
	String.prototype.reverse = function() {
		var r = '';
		for (var i = this.length - 1; i >= 0; i--) {
			r += this[i];
		}
		return r;
	};
	s.reverse();
}

function applyFunction() {
	
	function Person(first, last, age) {
		this.first = first;
		this.last = last;
		this.age = age;
		this.fullName = function() { // every object has function object 
			return this.first + ' ' + this.last;
		};
	}	

	//The first argument to apply() is the object that can be refered by 'this'.
	var applied = {};
	Person.apply(applied, ['alf', 'tan', 84]);

	console.log(applied.fullName());
}

function closures() {
	
	// function with context, a is context 
	function makeAdder(a) {
		return function(b) {
			return a + b;
		};
	}
	var x = makeAdder(5);  // x is a function instance of makeAdder, with context a = 5
	var y = makeAdder(20); // x is another function instance of makeAdder, with context a = 20
	x(6); // 11
	y(7); // 27
}