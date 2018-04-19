<?php
// Get the PHP helper library from https://twilio.com/docs/libraries/php
require_once '/path/to/vendor/autoload.php'; // Loads the library
use Twilio\Rest\Client;

// Your Account Sid and Auth Token from twilio.com/console
$apiKeySid = "SKXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX";
$apiKeySecret = "your_auth_apiKeySecret";
$client = new Client($apiKeySid, $apiKeySecret);

$groupRoom = $client->video->rooms->create([
    'uniqueName' => 'DailyStandup',
    'type' => 'group',
    'recordParticipantsOnConnect' => true,
    'statusCallback' => 'http://example.org'
]);

echo $groupRoom->sid;
