## AWS account root user

When you first create an AWS account, you begin with one sign-in identity that has complete access to all AWS services and resources in the account. This identity is called the AWS account *root user* and is accessed by signing in with the email address and password that you used to create the account.

## IAM users

An *[IAM user](https://docs.aws.amazon.com/IAM/latest/UserGuide/id_users.html)* is an identity within your AWS account that has specific permissions for a single person or application.

As a security [best practice](https://docs.aws.amazon.com/IAM/latest/UserGuide/best-practices.html), we recommend that you provide access to your resources through identity federation instead of creating IAM users. For information about specific situations where an IAM user is required, see [When to create an IAM user (instead of a role)](https://docs.aws.amazon.com/IAM/latest/UserGuide/id.html#id_which-to-choose).

## When to use IAM Identity Center users?

We recommend that all human users use IAM Identity Center to access AWS resources. IAM Identity Center enables significant improvements over accessing AWS resources as an IAM user. IAM Identity Center provides:

* A central set of identities and assignments
* Access to accounts across an entire AWS Organization
* Connection to your existing identity provider
* Temporary credentials
* Multi-factor authentication (MFA)
* Self-service MFA configuration for end-users
* Administrative enforcement of MFA usage
* Single sign-on to all AWS account entitlements

## IAM user groups

An [*IAM group*](https://docs.aws.amazon.com/IAM/latest/UserGuide/id_groups.html) is an identity that specifies a collection of IAM users. You can't use a group to sign-in. You can use groups to specify permissions for multiple users at a time. Groups make permissions easier to manage for large sets of users. For example, you could have a group named *IAMPublishers* and give that group the types of permissions that publishing workloads typically need.


# IAM roles

An IAM *role* is an IAM identity that you can create in your account that has specific permissions. An IAM role is similar to an IAM user, in that it is an AWS identity with permission policies that determine what the identity can and cannot do in AWS. However, instead of being uniquely associated with one person, a role is intended to be assumable by anyone who needs it. Also, a role does not have standard long-term credentials such as a password or access keys associated with it. Instead, when you assume a role, it provides you with temporary security credentials for your role session.

# Policies and permissions in IAM

You manage access in AWS by creating policies and attaching them to IAM identities (users, groups of users, or roles) or AWS resources. A policy is an object in AWS that, when associated with an identity or resource, defines their permissions. AWS evaluates these policies when an IAM principal (user or role) makes a request.

Permissions in the policies determine whether the request is allowed or denied. Most policies are stored in AWS as JSON documents. AWS supports six types of policies: identity-based policies, resource-based policies, permissions boundaries, Organizations SCPs, ACLs, and session policies.

## Policy types

The following policy types, listed in order from most frequently used to less frequently used, are available for use in AWS. For more details, see the sections below for each policy type.

* **[Identity-based policies](https://docs.aws.amazon.com/IAM/latest/UserGuide/access_policies.html#policies_id-based)** – Attach [managed](https://docs.aws.amazon.com/IAM/latest/UserGuide/access_policies.html#managedpolicy) and [inline](https://docs.aws.amazon.com/IAM/latest/UserGuide/access_policies.html#inline) policies to IAM identities (users, groups to which users belong, or roles). Identity-based policies grant permissions to an identity.
* **[Resource-based policies](https://docs.aws.amazon.com/IAM/latest/UserGuide/access_policies.html#policies_resource-based)** – Attach inline policies to resources. The most common examples of resource-based policies are Amazon S3 bucket policies and IAM role trust policies. Resource-based policies grant permissions to the principal that is specified in the policy. Principals can be in the same account as the resource or in other accounts.
* **[Permissions boundaries](https://docs.aws.amazon.com/IAM/latest/UserGuide/access_policies.html#policies_bound)** – Use a managed policy as the permissions boundary for an IAM entity (user or role). That policy defines the maximum permissions that the identity-based policies can grant to an entity, but does not grant permissions. Permissions boundaries do not define the maximum permissions that a resource-based policy can grant to an entity.
* **[Organizations SCPs](https://docs.aws.amazon.com/IAM/latest/UserGuide/access_policies.html#policies_scp)** – Use an AWS Organizations service control policy (SCP) to define the maximum permissions for account members of an organization or organizational unit (OU). SCPs limit permissions that identity-based policies or resource-based policies grant to entities (users or roles) within the account, but do not grant permissions.
* **[Access control lists (ACLs)](https://docs.aws.amazon.com/IAM/latest/UserGuide/access_policies.html#policies_acl)** – Use ACLs to control which principals in other accounts can access the resource to which the ACL is attached. ACLs are similar to resource-based policies, although they are the only policy type that does not use the JSON policy document structure. ACLs are cross-account permissions policies that grant permissions to the specified principal. ACLs cannot grant permissions to entities within the same account.
* **[Session policies](https://docs.aws.amazon.com/IAM/latest/UserGuide/access_policies.html#policies_session)** – Pass advanced session policies when you use the AWS CLI or AWS API to assume a role or a federated user. Session policies limit the permissions that the role or user's identity-based policies grant to the session. Session policies limit permissions for a created session, but do not grant permissions. For more information, see [Session Policies](https://docs.aws.amazon.com/IAM/latest/UserGuide/access_policies.html#policies_session).
