#!/usr/bin/python 

import random 
import seq_helpers.py


#runs on sequence forward and backward along the other to check for complementarity
def percent_match( seq1, seq2 ):
	#list formatted as [max-number-complementary, index, index, index]
    print "percent_match \n    returns the percentage of complementarity between two strings of bases\n"
    #assume both strings are passed '3 --> '5                                                                                                                                                                                                 
    #reverse one string for binding
	reverse(seq1)
	len1 = len(seq1)
	len2 = len(seq2)
	num_matches = 0
	num_comped = 0
	p1 = len1 - 1
	p2 = 0
	while (p2 < len2):
		num_matches += substring_match(seq1[p1:], seq2[p2:]) ]
		num_comped += len(seq1[p1:])
		if (p1 > 0):
			p1--
		else:
			p2++
	return num_matches
    
#dictionary saves number of matches as key and indexes of each array in the value array
#maximum key value is saved as is to reduce number of values saved in the dictionary
def find_binding_sites( seq1, seq2 ):
    reverse(seq1)                                                                                                                                                                                  
	len1 = len(seq1)
	len2 = len(seq2)
	max_val = 0
	num_matches = {}
	p1 = len1 - 1
	p2 = 0
	while (p2 < len2):
		num_matches[ substring_match(seq1[p1:], seq2[p2:]) ] += (p1, p2)
		if (p1 > 0):
			p1--
		else:
			p2++
	max_val = max(num_matches.keys())
	return [max_val, dict[max_val]]
	#returns array of a num and an array of the coordinates
	
#runs on two substrings; they may be different length
def substring_match( sub1, sub2 ):
	print "substring match\n"
	print "    returns the number of complementary bases between two substrings"
	len1 = len( sub1 )
	len2 = len( sub2 )
	matches = 0
	i = 0
	while ( len1 > 0 && len2 > 0 )
		if ( comp(sub1[i], sub2[i]) )
			matches++
		len1-- 
		len2--
		i++
	return matches

