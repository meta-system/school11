import random

class MergeSort:
    @staticmethod
    def sort(unsorted_list):
        if len(unsorted_list) == 1:
            rlist = unsorted_list
        else:
            q = len(unsorted_list)//2
            rlist = MergeSort.merge(MergeSort.sort(unsorted_list[:q]), MergeSort.sort(unsorted_list[q:]))
        print(unsorted_list, "->", rlist)
        return rlist
    @staticmethod
    def merge(list1, list2):
        rlist = []
        while list1 and list2:
            if list1[0] < list2[0]:
                rlist.append(list1.pop(0))
            else:
                rlist.append(list2.pop(0))
        return rlist+list1+list2 #one of list1 and list2 is empty

random_list = list(range(20))
random.shuffle(random_list)

print(MergeSort.sort(random_list))
