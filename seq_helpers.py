#!/usr/bin/python

import random

def random_seq( length ):
	#/print "random_seq\n    returns a random sequence of length l"
	bases = ['A','T','C','G']
	seq = ""
	for l in range(0, length):
		r = random.randrange(0,4)
		seq += bases[ r ]
	return seq

#takes two bases and returns true if complementary; does not account for U
def comp( base1, base2 ):
	if ( base1 == "A" and base2 == "T" ):
		return True
	elif ( base1 == "T" and base2 == "A" ):
		return True
	elif ( base1 == "G" and base2 == "C" ):
		return True
	elif ( base1 == "C" and base2 == "G" ):
		return True
	else:
		return False

#reverse some string
def reverse( s ):
	return s[::-1]

'''
print "TESTING SEQ_HELPERS.PY \n"
print "Testing random_seq"
seq1 = random_seq(20)
print seq1 
seq2 = random_seq(20)
print seq2 
seq3 = random_seq(10)
print seq3 
print "\nTesting comp"
print str(comp('A', 'T'))
print str(comp('G', 'T'))
print "\nTesting reverse"
print seq1 + "\n" + reverse(seq1)
'''



