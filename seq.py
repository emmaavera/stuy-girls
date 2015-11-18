#!/usr/bin/python 
                                                                                                                                                                                                                            
import random 
import seq_helpers.py


#runs on sequence forward and backward along the other to check for complementarity                                                                                                                                                           
def percent_match( seq1, seq2 ):
	#list formatted as [max-number-complementary, index, index, index]
    print "percent_match \n    returns the percentage of complementarity between two strings of bases\n"
    #assume both strings are passed '3 --> '5                                                                                                                                                                                                 
    #reverse one string for binding
      
#dictionary saves number of matches as key and indexes of each array in the value array
#maximum key value is saved as is to reduce number of values saved in the dictionary
def find_binding_site( seq1, seq2 ):
                                                                                                                                                                                  


	
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

