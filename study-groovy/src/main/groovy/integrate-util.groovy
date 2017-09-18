println "${x}, ${who}" //get from binding

def who='util'

['a', 'b', 'c'].each {
	println "Item: $it" // `it` is an implicit parameter corresponding to the current element
}

def x=100+100

setProperty('who', 'I am shared data!')
setProperty('x', 200)

x=300 //the last value assigned will be the return result of the script
