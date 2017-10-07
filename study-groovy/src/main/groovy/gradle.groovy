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


def task(action) { {
	what -> 
	action(what())
}
}


task(hello).{
	doLast {
	   println 'tutorialspoint'
	}
}

task hello2 {
	doLast {
	   println 'tutorialspoint2'
	}
}


1.upto(4, {
	println "Number ${it}"
})