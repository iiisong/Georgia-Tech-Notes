text_matrix = '''

x1 x2 x3 x4 x5  
1  3  0  7  0  |  4  
0  0  1  4  0  |  5  
0  0  0  0  1  |  6
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
        row_text = "\n" + " & ".join(elems) + "\\\[0.4em]"
        result += row_text
    
    result += '''\n\\end{bmatrix}\n$$'''

    print(result)
    

text_to_matrix(text_matrix)




