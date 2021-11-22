import random
import requests, lxml
from bs4 import BeautifulSoup
website = 'https://www.google.com/search?q=fun%20fact%20about%20'
userinput = 'tesla'
website += userinput
print(website)

headers = {'User-Agent': 'Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/64.0.3282.186 Safari/537.36'}
r = requests.get(website, headers=headers)
soup = BeautifulSoup(r.text, 'lxml')
listarray = soup.findAll("li", {"class": "TrT0Xe"})
randomnum = random.randint(0,4)
print(listarray[randomnum].text)
# result = soup.find('li', class_='TrT0Xe')

# print(result.text)