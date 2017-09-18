//@GrabResolver(name='spring', root='https://search.maven.org/')
@Grab(group='org.springframework', module='spring-beans', version='4.3.11.RELEASE')
import java.beans.PropertyChangeListener

import org.springframework.beans.BeanWrapper


def scriptPath = getClass().protectionDomain.codeSource.location.path
def scriptFile = scriptPath.substring(scriptPath.lastIndexOf('/') + 1)
def scriptFolder = scriptPath.substring(0, scriptPath.lastIndexOf('/'))

println scriptPath
println scriptFolder
println scriptFile

new File(scriptPath).eachLine() { line, number ->
	println "\tLine $number: $line"
}
println "===================="

def lineCount = 0
new File(scriptFolder,scriptFile).withReader { reader ->
	while (reader.readLine()) {
		lineCount++
	}
}

println "LineCount $lineCount"
println "LineCount ${lineCount}"
println "LineCount {$lineCount}"


def list1 = ['a', 'b', 'c']
//construct a new list, seeded with the same items as in list1
def list2 = new ArrayList<String>(list1)

assert list2 == list1 // == checks that each corresponding element is the same (ie. list2.compareTo(list1) == 0)

// clone() can also be called
def list3 = list1.clone()
assert list3 == list1

assert ![]             // an empty list evaluates as false

['a', 'b', 'c'].each {
	println "Item: $it" // `it` is an implicit parameter corresponding to the current element
}

['a', 'b', 'c'].eachWithIndex { item, ii -> // `it` is the current element, while `i` is the index
	println "$ii: $item"
}

def l = ['a', 'b', 'c'].collect { 
	it.multiply(2) 
}

l.forEach{
	println "Item multiple: $it" 
}


// shortcut syntax instead of collect
assert [1, 2, 3]*.multiply(2) == [1, 2, 3].collect { it.multiply(2) }

def list = [0]
// it is possible to give `collect` the list which collects the elements
assert [1, 2, 3].collect(list) { it * 2 } == [0, 2, 4, 6]
assert list == [0, 2, 4, 6]

// we can use a closure to specify the sorting behaviour
def list2a = ['abc', 'z', 'xyzuvw', 'Hello', '321', '1']
assert list2a.max { it.size() } == 'xyzuvw'
assert list2a.min { it.size() } == 'z'

assert list2a.max() == 'z'
assert list2a.min() == '1'



// << vs +
assert ([1, 2] << 3 << [4, 5] << 6) == [1, 2, 3, [4, 5], 6]
assert [1, 2] + 3 + [4, 5] + 6 == [1, 2, 3, 4, 5, 6]

def mut = [1, 2]
def mut2 = mut + 3
mut.each {
	println "mut Item: $it" 
}
mut2.each {
	println "mut2 Item: $it" 
}


// *[]
assert [1, *[222, 333], 456] == [1, 222, 333, 456]
assert [*[1, 2, 3]] == [1, 2, 3]
assert [1, [2, 3, [4, 5], 6], 7, [8, 9]].flatten() == [1, 2, 3, 4, 5, 6, 7, 8, 9]

def map = [name: 'Gromit', likes: 'cheese', id: 1234]
assert map.get('name') == 'Gromit'
assert map.get('id') == 1234

assert map.name == 'Gromit'     // can be used instead of map.get('name')
assert map.id == 1234


def map2 = [
	Bob  : 42,
	Alice: 54,
	Max  : 33
]

// `entry` is a map entry
map2.each { entry ->
	println "Name: $entry.key Age: $entry.value"
}

// `entry` is a map entry, `i` the index in the map
map2.eachWithIndex { entry, i ->
	println "$i - Name: $entry.key Age: $entry.value"
}

// Alternatively you can use key and value directly
map2.each { key, value ->
	println "Name: $key Age: $value"
}


//The star-dot `*.' operator
//The "star-dot" operator is a shortcut operator allowing you to call a method or a property on all elements of a collection:

assert [1, 3, 5] == ['a', 'few', 'words']*.size()

class Person {
	String name
	int age
}
def persons = [new Person(name:'Hugo', age:17), new Person(name:'Sandra',age:19)]
assert [17, 19] == persons*.age

//Spread operator
//The spread operator can be used to "inline" a collection into another. It is syntactic sugar which often avoids calls to putAll and facilitates the realization of one-liners:

def f = { [1: 'u', 2: 'v', 3: 'w'] }
assert [*: f(), 10: 'zz'] == [1: 'u', 10: 'zz', 2: 'v', 3: 'w']
//spread map notation in function arguments
f = { mapa -> mapa.c }
assert f(*: ['a': 10, 'b': 20, 'c': 30], 'e': 50) == 30

def listener = {
	if (it instanceof ObservableList.ElementEvent)  {
		assert it instanceof ObservableList.ElementAddedEvent
		assert it.changeType == ObservableList.ChangeType.ADDED
		assert it.index == 3
		assert it.oldValue == null
		assert it.newValue == 42
		println "$it"
	}
} as PropertyChangeListener


def observable = [1, 2, 3] as ObservableList
observable.addPropertyChangeListener(listener)
observable.add 42



class TranslationService {
	String convert(String key) {
		return "test"
	}
}
// map coercion for non-single method interface/class
def service = [convert: { String key -> 'some text' }] as TranslationService
assert 'some text' == service.convert('key.text')

// closure coercion for single method interface/class
def service = { String key -> 'some text' } as TranslationService


//MockFor, very similiar to java dynamic proxy
class FamilyPerson {
	String first, last
}

class Family {
	FamilyPerson father, mother
	def nameOfMother() { "$mother.first $mother.last" }
}

def mock = new MockFor(FamilyPerson)
mock.demand.getFirst{ 'dummy' } // intercept the class getter by closure syntax
mock.demand.getLast{ 'name' }   // very similiar to JMock new Expectations
mock.use {
	def mary = new FamilyPerson(first:'Mary', last:'Smith')
	def f = new Family(mother:mary)
	assert f.nameOfMother() == 'dummy name' // get intercepted value from 
}
mock.expect.verify() // very similiar to JMock assertIsSatisfied





















