![ms-icon-150x150.png](https://bitbucket.org/repo/K8XgxE/images/133596055-ms-icon-150x150.png)

# Accunity Reusable #
========

This a AEM content package project generated using the multimodule-content-package-archetype.

Contributors
--------
1. Ankur Mittal - [ankur@accunitysoft.com](Link URL)
2. Pankaj Bansal - [pankaj@accunitysoft.com](Link URL)
3. Ankur Chauhan - [achauhan@accunitysoft.com](Link URL)
4. Saurabh Gupta - [saurabh@accunitysoft.com](Link URL)
5. Shivani Garg - [shivanig@accunitysoft.com](Link URL)

Building
--------

This project uses Maven for building. Common commands:

From the root directory, run ``mvn -PautoInstallPackage clean install`` to build the bundle and content package and install to a CQ instance.

From the bundle directory, run ``mvn -PautoInstallBundle clean install`` to build *just* the bundle and install to a CQ instance.

Using with VLT
--------------

To use vlt with this project, first build and install the package to your local CQ instance as described above. Then cd to `content/src/main/content/jcr_root` and run

    vlt --credentials admin:admin checkout -f ../META-INF/vault/filter.xml --force http://localhost:4502/crx

Once the working copy is created, you can use the normal ``vlt up`` and ``vlt ci`` commands.

Specifying CRX Host/Port
------------------------

The CRX host and port can be specified on the command line with:
mvn -Dcrx.host=otherhost -Dcrx.port=5502 <goals>