function lunes() {
  console.log('lunes');
}

function martes() {
  console.log('martes');
}

function miercoles() {
  console.log('miercoles');
}

function jueves() {
  console.log('jueves');
}

function viernes() {
  console.log('viernes');
}
 
const weekdays = [lunes, martes, miercoles, jueves, viernes];


Object.keys(weekdays).map((a, b, c) => console.log(a + ' ' + b + ' ' + c));

const weekdaysM = {
  l: lunes, 
  m: martes, 
  m2: miercoles, 
  j: jueves, 
  v: viernes
};

Object.keys(weekdaysM).map((a, b, c) => console.log(a + ' ' + b + ' ' + c));

const weekdays2 = {lunes, martes, miercoles, jueves, viernes};
Object.keys(weekdays2).map((a, b, c) => console.log(a + ' ' + b + ' ' + c));


let w1 = 'lunes';
let w2 = 'martes';
let w3 = 'miercoles';
let w4 = 'jueves';
let w5 = 'viernes';

const weekdays3 = {w1, w2, w3, w4, w5};
console.log(JSON.stringify(weekdays3));


const weekdays4 = {w1: w1, w2: w2};
console.log(JSON.stringify(weekdays4));

Object.keys(weekdays4).map(a => console.log('type : ' + typeof(a)));

const weekdays5 = {'w1': w1, 'w2': w2};
console.log(JSON.stringify(weekdays5));

Object.keys(weekdays5).map((a, b) => console.log('type : ' + typeof(a) + ' ' + a + ' ' + b));

Object.keys(weekdays5).forEach((a, b) => console.log('type : ' + typeof(a) + ' ' + a + ' ' + b + ' ' + weekdays5[a] + ' ' + weekdays5[b]));
