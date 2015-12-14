<?php

/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
ini_set('display_errors', 1);
error_reporting(E_ALL);

require(__DIR__ . '/lib/SplClassLoader.php');

$classLoader = new SplClassLoader('WebSocket', __DIR__ . '/lib');
$classLoader->register();

$server = new \WebSocket\Server('127.0.0.1', 8000, false);

$server->setMaxClients(100);

$server->setCheckOrigin(false);

$server->setMaxConnectionsPerIp(100);
$server->setMaxRequestsPerMinute(2000);

$server->registerApplication('mazerunner', \WebSocket\Application\MazeApplication::getInstance());

$server->run();
