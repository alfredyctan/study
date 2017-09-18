// can omit the ()
// equivalent to: turn(left).then(right)
turn left then right

// equivalent to: take(2.pills).of(chloroquinine).after(6.hours)
take 2.pills of chloroquinine after 6.hours

// equivalent to: paint(wall).with(red, green).and(yellow)
paint wall with red, green and yellow

// with named parameters too
// equivalent to: check(that: margarita).tastes(good)
check that: margarita tastes good

// with closures as parameters
// equivalent to: given({}).when({}).then({})
given { } when { } then { }




// so many closure...!!
show = { println it }
square_root = { Math.sqrt(it) }

def please(action) {
	[the: { 
		what -> [of: { 
			n -> action(what(n)) 
		}]
	}]
}

// equivalent to: please(show).the(square_root).of(100)
please show the square_root of 100
// ==> 10.0


// a + b	a.plus(b)
// a - b	a.minus(b)
// a * b	a.multiply(b)
// a ** b	a.power(b)
// a / b	a.div(b)
// a % b	a.mod(b)
// a | b	a.or(b)
// a & b	a.and(b)
// a ^ b	a.xor(b)
// a++ or ++a	a.next()
// a-- or --a	a.previous()
// a[b]	a.getAt(b)
// a[b] = c	a.putAt(b, c)
// a << b	a.leftShift(b)
// a >> b	a.rightShift(b)
// a >>> b	a.rightShiftUnsigned(b)
// switch(a) { case(b) : }	b.isCase(a)
// if(a)	a.asBoolean()
// ~a	a.bitwiseNegate()
// -a	a.negative()
// +a	a.positive()
// a as b	a.asType(b)
// a == b	a.equals(b)
// a != b	! a.equals(b)
// a <=> b	a.compareTo(b)
// a > b	a.compareTo(b) > 0
// a >= b	a.compareTo(b) >= 0
// a < b	a.compareTo(b) < 0
// a <= b	a.compareTo(b) <= 0
