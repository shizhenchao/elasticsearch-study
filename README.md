# Resilience in larger clusters

## 一个节点的集群

节点完成所有工作，拥有所有角色，要保证状态是green，则必须保证至少有一个replica ，通过设置t `index.number_of_replicas` = `0`

生产环境下不建议使用。