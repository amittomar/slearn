println(1+3)

def abs(d: Double) = if (d < 0) -d else d

def isGoodEnough(guess: Double, x: Double) = {
  abs(guess *guess -x) < 0.0001
}

def improve(guess: Double, x: Double) = (guess + x/guess)/2

def sqrtIter(guess : Double, x :Double) : Double ={
  if(isGoodEnough(guess,x)) guess
  else sqrtIter(improve(guess,x),x)
}

def sqrt(x:Double) = sqrtIter(1.0,x)

println(sqrt(2))
println(sqrt(4))
println(sqrt(16))
println(sqrt(1e-6))
sqrt(sqrt(1e60))


