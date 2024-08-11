
# What is the AWS Shared Responsibility Model?

The AWS shared resnsibility model defines the allocation of security & compliance duties between AWS and its customers.

AWS is accountable for ensuring the  ***“security of the cloud”*** , safeguarding its infrastructure and services. This infrastructure encompasses the hardware, software, networking, and facilities necessary for operating AWS Cloud services.
Moreover, AWS also prioritizes,

**✔ Sustainability of the Cloud**
AWS prioritizes sustainability in the cloud by investing in efficient technology and serving to minimize energy usage and environmental impact. It encourages resource sharing among cloud workloads to reduce further energy consumption. Additionally, it offers options for customers to migrate to even more efficient systems and leverage cloud services.

**✔ Resilience of the Cloud**
AWS also emphasizes resilience by ensuring infrastructure reliability, meeting service agreements, and establishing multiple isolated availability zones within each region, interconnected by high-speed networks, to safeguard against power outages and natural disasters and ensure smooth application operation.

Conversely, customers are responsible for maintaining ***“security in the cloud,”*** which involves securely configuring and utilizing AWS resources and protecting their data and applications. The customer’s responsibilities with AWS depend on the services they choose.

Moreover, customers can also prioritize,

**✔ Sustainability in the Cloud**
Cloud sustainability emphasizes minimizing energy consumption and optimizing efficiency across every aspect of a workload. It includes choosing efficient programming languages, algorithms, and data storage techniques, deploying appropriately sized compute infrastructure, and minimizing high-powered hardware requirements.

**✔ Resilience in the Cloud**
Your responsibilities on AWS depend on the services you choose. For services like Amazon EC2, customers handle resiliency tasks like deploying across Availability Zones and implementing self-healing. AWS manages infrastructure for managed services like Amazon S3, but customers handle data resiliency tasks like backup and replication. Deploying across Availability Zones ensures high availability and forms part of an [AWS disaster recovery strategy](https://www.bacancytechnology.com/blog/aws-disaster-recovery) to protect against outages and disasters.

### A. Customer Responsibilities [Security in the Cloud]

The AWS shared responsibility model outlines explicitly customers’ responsibilities, which are mentioned below.

| **Category**                             | **Responsibilities**                                                                                                                                                                                      |
| ---------------------------------------------- | --------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------- |
| **Customer Data**                        | Data management, including encryption, storage, and access controls, is handled by AWS, which also ensures the security of the underlying infrastructure.                                                       |
| **Platforms**                            | Securing and configuring AWS applications includes patching and managing access controls.                                                                                                                       |
| **Applications**                         | Ensuring the security of applications through authentication, encryption, and regular auditing, while AWS guarantees the availability and security of the underlying infrastructure.                            |
| **Identity and Access Management (IAM)** | Enforcing IAM practices, creating and managing users, roles, and permissions, and setting up multifactor authentication. AWS provides tools and services for IAM and ensures service security.                  |
| **Operating Systems**                    | Managing and securing operating systems of VM or EC2 instances, including patching and vulnerability monitoring. AWS manages physical hosts and hypervisors.                                                    |
| **Network Configuration**                | Setting up network configurations such as VPC settings, subnet structures, security group policies, and network ACLs, with AWS ensuring the security and availability of the underlying network infrastructure. |
| **Firewall Configuration**               | Setting up firewalls, security group rules, and network ACLs to manage traffic flow while AWS furnishes the necessary physical network infrastructure and firewalls for optimal configuration.                  |
| **Client-Side Data Encryption**          | Ensuring data encryption prior to uploading to AWS services, managing encryption keys, and implementing stringent access controls while AWS furnishes secure infrastructure and encryption alternatives.        |
| **Data Integrity Authentication**        | Ensuring data integrity and authenticity through hashing, signing, and verifying data. AWS offers features like AWS CloudTrail for monitoring and logging.                                                      |
| **Server-Side Encryption**               | Choosing and managing server-side encryption options for data stored within AWS services. AWS ensures proper implementation and maintenance of encryption features.                                             |
| **Networking Traffic Protection**        | Implementing traffic protection measures like SSL/TLS encryption, VPNs, or AWS Direct Connect. AWS ensures secure and resilient network infrastructure.                                                         |
