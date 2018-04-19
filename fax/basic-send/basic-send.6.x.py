from twilio.rest import Client

# put your own credentials here
account_sid = "ACXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX"
auth_token = "your_auth_token"

client = Client(account_sid, auth_token)

fax = client.fax.v1.faxes.create(
    from_="+15017122661",
    to="+15558675310",
    media_url="https://www.twilio.com/docs/documents/25/justthefaxmaam.pdf"
)

print(fax.sid)
