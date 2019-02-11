def refresh():
    global string1
    string1 = '   |   |   '
    global string2
    string2 = '   |   |   '
    global string3
    string3 = '   |   |   '


def grid():
    print('   |   |   ')
    print(string3)
    print('___|___|___')
    print('   |   |   ')
    print(string2)
    print('___|___|___')
    print('   |   |   ')
    print(string1)
    print('   |   |   ')


def place(a, b):
    global string1
    global string2
    global string3
    # Line 1
    if a == 1:
        string1 = string1[0] + b + string1[2:]
        grid()
    if a == 2:
        string1 = string1[:5] + b + string1[6:]
        grid()
    if a == 3:
        string1 = string1[:9] + b + string1[10:]
        grid()

    # Line 2
    if a == 4:
        string2 = string2[0] + b + string2[2:]
        grid()
    if a == 5:
        string2 = string2[:5] + b + string2[6:]
        grid()
    if a == 6:
        string2 = string2[:9] + b + string2[10:]
        grid()
    # Line 3

    if a == 7:
        string3 = string3[0] + b + string3[2:]
        grid()
    if a == 8:
        string3 = string3[:5] + b + string3[6:]
        grid()
    if a == 9:
        string3 = string3[:9] + b + string3[10:]
        grid()
    b = ''


def run():
    print('Welcome to my game')
    refresh()
    grid()
    key = 'X'
    x = 0
    win = True
    values = {'1': 1, '2': 2, '3': 3, '4': 4, '5': 5, '6': 6, '7': 7, '8': 8, '9': 9}
    print('Welcome to TikTakToe... By Viren')
    p1 = input('Enter player1 name, Your key will be X\n')
    p2 = input('Enter player2 name, Your key will be O\n')
    print('\n')
    while (not (x == 8)) and win:
        print('\n')
        if x % 2 == 0:
            print(p1 + "'s Turn with key X")
            key = 'X'
            posi = input('Enter the position of the key\n')
            if values[posi] == int(posi):
                values[posi] = key
                place(int(posi), key)
            else:
                grid()
                print('place filled. please enter somewhere else')
                x -= 1
        else:
            print(p2 + "'s Turn with key O")
            key = 'O'
            posi = input('Enter the position of the key\n')
            if values[posi] == int(posi):
                values[posi] = key
                place(int(posi), key)
            else:
                grid()
                print('\nPlace filled. please enter somewhere else')
                x -= 1
        if ((values['1'] == values['2'] and values['2'] == values['3'])  # 123
                or (values['4'] == values['5'] and values['5'] == values['6'])  # 456
                or (values['7'] == values['8'] and values['8'] == values['9'])  # 789
                or (values['1'] == values['4'] and values['4'] == values['7'])  # 147
                or (values['2'] == values['5'] and values['5'] == values['8'])  # 258
                or (values['3'] == values['6'] and values['6'] == values['9'])  # 369
                or (values['1'] == values['5'] and values['5'] == values['9'])  # 159
                or (values['3'] == values['5'] and values['5'] == values['7'])):  # 357
            win = False
        x += 1

    if win:
        print('Darn it... Its a Draw...')
    else:
        if key == 'X':
            print(f'Player 1: {p1} has won the game. Congratulations')
        else:
            print(f'Player 2: {p2} has won the game. Congratulations')
    if input('Do you wanna restart? Enter Y for Yes and N for No\n') == 'Y':
        refresh()
        run()
    else:
        print('Thank You for Playing')
        refresh()
run()