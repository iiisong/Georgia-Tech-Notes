text_vector = '''
4
2
h
'''


def text_to_vector (text_vector):
    result = '''$$\n\\begin{pmatrix}'''

    list_vector = text_vector.split("\n")
    r_num = len(list_vector)
    c_num = len(list_vector[0].split(" "))

    for r in list_vector:

        elems = [i for i in r.split(" ") if len(i) != 0]
        
        if len(elems) == 0:
            continue

        row_text = "\n"

        if len(elems) > 1:
            row_text += "& "
            
        row_text += " & ".join(elems)
        
        if len(elems) > 1:
            row_text += "& \\\[0.4em]"
        
        else:
            row_text += "\\\[0.4em]"
            
        
        result += row_text
    
    result += '''\n\\end{pmatrix}\n$$'''

    print(result)
    

text_to_vector(text_vector)




