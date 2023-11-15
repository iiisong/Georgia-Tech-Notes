text_matrix = '''
a b 
c d
'''

text_matrix


def text_to_matrix (text_matrix):
    result = '''$$\n\\begin{bmatrix}'''

    list_matrix = text_matrix.split("\n")
    r_num = len(list_matrix)
    c_num = len(list_matrix[0].split(" "))

    for r in list_matrix:

        elems = [i for i in r.split(" ") if len(i) != 0]
        
        if len(elems) == 0:
            continue

        row_text = "\n"

        if len(elems) > 1:
            row_text += "& "
            
        row_text += " & ".join(elems)
        
        if len(elems) > 1:
            row_text += " & \\\\"
        
        else:
            row_text += "\\\\"
            
        
        result += row_text
    
    result += '''\n\\end{bmatrix}\n$$'''

    print(result)
    

text_to_matrix(text_matrix)




