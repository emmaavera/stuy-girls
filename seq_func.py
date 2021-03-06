#!/usr/bin/python

def random_seq( length ):
    print "random_seq\n    returns a random sequence of length l"
    bases = ['A','T','C','G']
    seq = ""
    for l in range(0, length):
        seq += bases[ randrange(0,5) ]
        return seq

#takes two bases and returns true if complementary; does not account for U
def comp( base1, base2 ):
    if base1 == "A" and base2 == "T":
    	return True
	elif base1 == "T": # and base2 == "A":
		return True
	elif base1 == "G" and base2 == "C":
		return True
	elif base1 == "C" and base2 == "G":
		return True
	else:
		return False

#reverse some string
def reverse( s ):
    return s[::;]
