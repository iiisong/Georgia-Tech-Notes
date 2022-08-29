text_matrix = '''

b_1
b_2
'''

def text_to_matrix (text_matrix):
    result = '''$$\n\\begin{bmatrix}'''

    list_matrix = text_matrix.split("\n")
    r_num = len(list_matrix)
    c_num = len(list_matrix[0].split(" "))

    for r in list_matrix:
        if len(r) == 0:
            continue

        elems = [i for i in r.split(" ") if len(i) != 0]
        
        row_text = ""
        if len(elems) > 1:
            row_text = "\n& "
            
        row_text += " & ".join(elems) + "& \\\[0.4em]"
        
        if len(elems) > 1:
            row_text += "& \\\[0.4em]"
        
        else:
            row_text += 
            
        
        result += row_text
    
    result += '''\n\\end{bmatrix}\n$$'''

    print(result)
    

text_to_matrix(text_matrix)




