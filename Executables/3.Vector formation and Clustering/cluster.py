import numpy as np
import pandas as pd
import matplotlib.pyplot as plt
from sklearn.cluster import KMeans

table = pd.read_csv("test.csv")
head = table.loc[:,["country"]]
table = table.loc[:,['health','education','public-cash','public-tax']]
#print(table.as_matrix())
km = KMeans(n_clusters=6)
prediction = km.fit_predict(table.as_matrix())
#print(prediction)
df = pd.DataFrame(prediction)
#print(df)
results = pd.concat([head,df],axis=1)
results.columns = ["Country","Cluster"]
print(results)
results.to_csv("test_results.csv")
