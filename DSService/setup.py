from setuptools import setup , find_packages

install_resources = [
    'Flask==3.1.2',
    'kafka_python==2.3.0',
    'langchain_core==1.2.6',
    'langchain_mistralai==1.1.1',
    'pydantic==2.12.5',
    'python-dotenv==1.2.1'
]

setup(
    name='ds-service',
    version='1.0',
    packages=find_packages('src'),
    package_dir={'':'src'},
    install_resources=install_resources,
    include_package_data=True
)