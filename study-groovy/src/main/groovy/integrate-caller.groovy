def scriptPath = getClass().protectionDomain.codeSource.location.path
def scriptFolder = scriptPath.substring(0, scriptPath.lastIndexOf('/'))

def b = new Binding(x:3, who:"?") // pass to script
def shell = new GroovyShell(b)
def result2 = shell.evaluate(new FileReader("${scriptFolder}/integrate-util.groovy"))

def x=b.getProperty('x')
def who=b.getProperty('who')
println "evaluated : ${result2}, x:${x}, who:${who}"
