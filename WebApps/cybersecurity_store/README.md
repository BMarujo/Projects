# SIO

## Description

This web application represents a simple vulnerable web app in the form of a store.

## Audited issues 
ASVS 2.1.1, 2.1.2, 2.1.3, 2.1.7, 2.1.8, 2.8.1, 3.2.2, 3.7.1, 5.1.1, 8.3.1, 8.3.2, 8.3.3, 8.3.4, 12.1.1, 13.1.3

## Implemented improvements

The application now has an encrypted database storage, a MFA and a solid password strength evaluator 

## Authors
- Daniel Emídio **Nº 108986**
- Henrique Coelho **Nº 108342**
- Bernardo Marujo **Nº 107322**
- Carlos Ferreira **Nº 108822**
- Gabriel Costa **Nº 109050**

## Execute

To run the original version of the web app:
```shell
cd app_org/
python -m venv venv
source venv/bin/activate
pip install cherrypy
pip install pillow
python main.py
```

To run the secure application:

```shell
cd app_sec/
python -m venv venv
source venv/bin/activate
pip install -r requirements.txt
python main.py
```

## Report 
You can view the detailed report by clicking the link:
📄 [View the Report](analysis/report.md)

