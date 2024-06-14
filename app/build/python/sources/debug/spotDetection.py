import cv2
import numpy as np
import os

def detect(s):
    # cv2.imwrite("./screenshot.bmp", input_file)
    directory_path = os.path.dirname(__file__)
    file_path = os.path.join(directory_path, s) #read img

    # img = cv2.imread(file_path)
    # cv2.imshow("original image", img)
    # cv2.waitKey(0)
    # cv2.destroyAllWindows()

    gray = cv2.imread(file_path, 0)

    # threshold
    th, threshed = cv2.threshold(gray, 100, 255,
                                 cv2.THRESH_BINARY_INV|cv2.THRESH_OTSU)

    # findcontours
    cnts = cv2.findContours(threshed, cv2.RETR_LIST, cv2.CHAIN_APPROX_SIMPLE)[-2]

    # filter by area
    s1 = 0
    s2 = 200 #dot size
    xcnts = []

    for cnt in cnts:
        if s1<cv2.contourArea(cnt) <s2:
            xcnts.append(cnt)

            # printing output
    str = "Dots number: {}".format(len(xcnts)) + "\n"

    avg_cnt = []
    for x in xcnts:
        avg_cnt.append(np.round(x.mean(axis=0)[0]))

    str += "Spot locations: {}".format(avg_cnt)

    # cv2.imshow("grayscale image", gray)
    # cv2.waitKey(0)
    # cv2.destroyAllWindows()
    # exit

    return str