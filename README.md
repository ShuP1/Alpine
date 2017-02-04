[![Build Status](https://travis-ci.org/stevespringett/alpine.svg?branch=3.0-dev)](https://travis-ci.org/stevespringett/alpine)

Alpine
=========

An opinionated scaffolding library that jumpstarts Java projects with an 
API-first design, secure defaults, and minimal dependencies. Alpine came 
about due to many commonalities between several of my personal and 
professional projects.

Design Features
-

* **API-First Design** - 
Alpine assumes an API-first design where REST (via JAX-RS) is
at its core. The servers resources are stateless and do not rely
on sessions. JSON Web Tokens (JWT) are used to maintain some state
and are signed with an HMAC.

* **API Documentation** - 
Swagger support is built-in, allowing you to document APIs and generate
Swagger 2.0 definitions with ease.

* **Authentications** - 
Alpine supports multiple types of principals including LDAP users and 
API keys, both of which can be integrated into teams for access control.

* **Simplified Event System** - 
Alpine can perform parallel processing of tasks using an asynchronous
pub/sub model. It can easily scale to consume as much or as little of 
available resources as necessary.

* **Secure By Default** - 
All REST resources are secure by default, requiring authentication to 
access them. Gone are the days of forgetting to protect a resource. 

* **Flexible Persistences** - 
Uses JDO, the most flexible Java persistence specification available. I 
never understood how JPA, a small subset of JDO, is viewed as progress.
It's not.

* **Minimal Dependencies** - 
Too many frameworks unnecessary increase the attack surface of applications 
built using them. Even a simple Hello World application is often susceptible 
to attack from the use of vulnerable components or poorly configured 
frameworks. Alpine includes what is necessary for a modern app, nothing more.

* **Control** - 
Frameworks often force developers higher up the stack, freeing them from
low-level details. While this is certainly a huge win for productivity, 
developers often don't understand how their app actually works. Alpine 
does not do this. It provides standards-based APIs in a pre-packaged 
library giving developers both full control over their app, as well as a
productivity jumpstart.

Why 'Alpine'
-
Alt-right American politics has devised many insults against liberal thought
and the people who practice it. The term 'snowflake' is often applied to 
such people as a derogatory insult in the absence of their own critical 
thinking ability. Although a creative term, it's highly ineffective and
does nothing to address global concerns. So 'Alpine' is the public celebration
of being a 'snowflake', named after the blankets of snow that cover the French
Alps. Besides, 'Alpine' has a certain je ne sais quoi to it.

Open source is truly one of the great liberal ideals. So Alpine is released
with an equally liberal Apache 2.0 license.

Alpine is also the brand name of high-end car audio equipment, a hobby I was
passionate about in my teens and twenties when I built many systems and often
competed in various sound-offs in Illinois and Wisconsin. The name is nostalgic
and brings to me a certain joy.

Alpine is not affiliated with the Docker container image by the same name. It's
interesting that both projects have minimalism as a goal, but this is merely
coincidence.

Is Alpine For You
-
My opinions are just that, mine. They will evolve over time. However, my belief
in sticking with open standards and not having to conform to the conventions of
a specific framework will likely never change. Alpine is lightweight, 
standards-based, and framework-free. If this appeals to you, give Alpine a try. 

Projects Using Alpine
-
If your open source or commercial project is using Alpine, feel free to add its
name:

* [Hakbot Origin Controller](https://github.com/hakbot/hakbot-origin-controller)
* [OWASP Dependency-Track](https://www.owasp.org/index.php/OWASP_Dependency_Track_Project)

Copyright & License
-

Alpine is Copyright (c) Steve Springett. All Rights Reserved.

Permission to modify and redistribute is granted under the terms of the 
[Apache License 2.0] [license]

Alpine makes use of several other open source libraries. Please see
the [NOTICE.txt] [notice] file for more information.

  [GitHub Wiki]: https://github.com/stevespringett/alpine/wiki
  [license]: https://github.com/stevespringett/alpine/blob/master/LICENSE.txt
  [notice]: https://github.com/stevespringett/alpine/blob/master/NOTICE.txt
