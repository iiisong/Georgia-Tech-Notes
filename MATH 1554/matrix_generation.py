text_matrix = '''
1 0 0 0
0 1 0 0
0 0 1 0
0 0 0 1 
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
            row_text += " & \\\[0.4em]"
        
        else:
            row_text += "\\\[0.4em]"
            
        
        result += row_text
    
    result += '''\n\\end{bmatrix}\n$$'''

    print(result)
    

text_to_matrix(text_matrix)




