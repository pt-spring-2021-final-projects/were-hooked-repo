

var FOLLOW_DISTANCE = 800;

var Fish = function(id) {
  this.id = id;
  this.entourage = [];
 

  this.ox = this.dx = Math.random() - 0.5;
  this.oy = this.dy = Math.random() - 0.5;

  this.x = canvas.width * Math.random();
  this.y = canvas.height * Math.random();

 
  Fish.prototype.angleToClosestFish = function(otherFish) {
    otherFish = otherFish == null ? this.following : otherFish;
    if (otherFish) {
      return Math.atan2(otherFish.y - this.y, otherFish.x - this.x);
    } else {
      return Number.MAX_VALUE;
    }
  }

  Fish.prototype.angleFromFishDirectionToClosestFish = function(otherFish) {
    otherFish = otherFish == null ? this.following : otherFish;
    if (otherFish) {
      return Math.abs(deltaAngle(this.angle, this.angleToClosestFish(otherFish)));
    } else {
      return Number.MAX_VALUE;
    }
  }

  Fish.prototype.angleDirectionDifference = function(otherFish) {
    otherFish = otherFish == null ? this.following : otherFish;

    if (otherFish) {
      Math.abs(deltaAngle(this.angle, otherFish.angle));
    } else {
      return Number.MAX_VALUE;
    }
  }




  Fish.prototype.calc = function() {
    this.ox = this.dx;
    this.oy = this.dy;
    var MAX_SPEED = 1.1;
    var maxSpeed = MAX_SPEED;


    if (this.following == null || py(this.x - this.following.x, this.y - this.following.y) > FOLLOW_DISTANCE) {
      if (this.following != null) {
        if (keyDown) affinityLine(this.following, this, "white");
        this.following.entourage.splice(this.following.entourage.indexOf(this));
      }

      this.following = null;


      var closestDistance = Number.MAX_VALUE;
      var closestFish = null;

      for (var i = 0; i < fishes.length; i++) {
        var fish = fishes[i];
        if (fish != this) {
          var distance = py(this.x - fish.x, this.y - fish.y);
     
          if (distance < closestDistance && fish.following != this && distance < FOLLOW_DISTANCE && this.angleFromFishDirectionToClosestFish(fish) < Math.PI * 0.25) {
            closestDistance = distance;
            closestFish = fish;
          }
        }
      }
      if (closestFish != null) {
        this.following = closestFish;
        closestFish.entourage.push(this);
      }
    }


    if (this.following != null) {

      this.followingDistance = py(this.x - this.following.x, this.y - this.following.y);
      this.distanceFactor = 1 - this.followingDistance / FOLLOW_DISTANCE;


      if (this.angleDirectionDifference() > (Math.PI * 0.9) && 
        this.angleFromFishDirectionToClosestFish() < (Math.PI * 0.2)) { 
        this.dx += this.following.x * 0.1;
        this.dy += this.following.y * 0.1;
        if (keyDown) affinityLine(this.following, this, "yellow");
      } else if (this.followingDistance > FOLLOW_DISTANCE * 0.3) { 
        this.dx += Math.cos(this.angleToClosestFish()) * (0.05 * this.distanceFactor);
        this.dy += Math.sin(this.angleToClosestFish()) * (0.05 * this.distanceFactor);
      }
      if (keyDown) affinityLine(this.following, this, "red");
    }

    if (this.x < canvas.width * .1 || this.x > canvas.width * .9 || this.y < canvas.height * .2 || this.y > canvas.height * .8) {
      this.dx += (canvas.width / 2 - this.x) / 5000;
      this.dy += (canvas.height / 2 - this.y) / 5000;
    }

    if (py(this.x - cursor.x, this.y - cursor.y) < FOLLOW_DISTANCE * 0.75) {
      this.dx -= (cursor.x - this.x) / 500;
      this.dy -= (cursor.y - this.y) / 500;
      maxSpeed = 4;
      if (keyDown) affinityLine(cursor, this, "green");
    }

    
    if (this.following != null) {
      for (var i = 0; i < this.following.entourage.length; i++) {
        var siblingFish = this.following.entourage[i];
        if (siblingFish !== this) {
          if (py(this.x - siblingFish.x, this.y - siblingFish.y) < FOLLOW_DISTANCE * 0.2) {
            if (keyDown) affinityLine(siblingFish, this, "yellow");
            this.dx -= (siblingFish.x - this.x) / 1000;
            this.dy -= (siblingFish.y - this.y) / 1000;
          }
        }
      }
    }


    this.angle = Math.atan2(this.dy, this.dx);


    var speed = Math.max(0.1, Math.min(maxSpeed, py(this.dx, this.dy)));

 
    this.dx = Math.cos(this.angle) * (speed + speedBoost);
    this.dy = Math.sin(this.angle) * (speed + speedBoost);

  
    this.x += this.dx;
    this.y += this.dy;
  }
}




var canvas = document.getElementById('fishtank');
var context = canvas.getContext('2d');

var fishes = [];


var speedBoostCountdown = 200,
  speedBoost = 0,
  SPEED_BOOST = 2;
var fishBitmap = new Image()
fishBitmap.onload = function() {
  update();
};
fishBitmap.src = 'data:image/png;base64,iVBORw0KGgoAAAANSUhEUgAAABQAAAAFCAYAAABFA8wzAAAAGXRFWHRTb2Z0d2FyZQBBZG9iZSBJbWFnZVJlYWR5ccllPAAAAyNpVFh0WE1MOmNvbS5hZG9iZS54bXAAAAAAADw/eHBhY2tldCBiZWdpbj0i77u/IiBpZD0iVzVNME1wQ2VoaUh6cmVTek5UY3prYzlkIj8+IDx4OnhtcG1ldGEgeG1sbnM6eD0iYWRvYmU6bnM6bWV0YS8iIHg6eG1wdGs9IkFkb2JlIFhNUCBDb3JlIDUuNS1jMDE0IDc5LjE1MTQ4MSwgMjAxMy8wMy8xMy0xMjowOToxNSAgICAgICAgIj4gPHJkZjpSREYgeG1sbnM6cmRmPSJodHRwOi8vd3d3LnczLm9yZy8xOTk5LzAyLzIyLXJkZi1zeW50YXgtbnMjIj4gPHJkZjpEZXNjcmlwdGlvbiByZGY6YWJvdXQ9IiIgeG1sbnM6eG1wPSJodHRwOi8vbnMuYWRvYmUuY29tL3hhcC8xLjAvIiB4bWxuczp4bXBNTT0iaHR0cDovL25zLmFkb2JlLmNvbS94YXAvMS4wL21tLyIgeG1sbnM6c3RSZWY9Imh0dHA6Ly9ucy5hZG9iZS5jb20veGFwLzEuMC9zVHlwZS9SZXNvdXJjZVJlZiMiIHhtcDpDcmVhdG9yVG9vbD0iQWRvYmUgUGhvdG9zaG9wIENDIChNYWNpbnRvc2gpIiB4bXBNTTpJbnN0YW5jZUlEPSJ4bXAuaWlkOjZEMjNEMUIyQjI1MTExRTM5QzhDQjczMjRDQUI3RkMwIiB4bXBNTTpEb2N1bWVudElEPSJ4bXAuZGlkOjZEMjNEMUIzQjI1MTExRTM5QzhDQjczMjRDQUI3RkMwIj4gPHhtcE1NOkRlcml2ZWRGcm9tIHN0UmVmOmluc3RhbmNlSUQ9InhtcC5paWQ6NkQyM0QxQjBCMjUxMTFFMzlDOENCNzMyNENBQjdGQzAiIHN0UmVmOmRvY3VtZW50SUQ9InhtcC5kaWQ6NkQyM0QxQjFCMjUxMTFFMzlDOENCNzMyNENBQjdGQzAiLz4gPC9yZGY6RGVzY3JpcHRpb24+IDwvcmRmOlJERj4gPC94OnhtcG1ldGE+IDw/eHBhY2tldCBlbmQ9InIiPz5h3qMOAAAAkUlEQVR42pyQsQrCQBBEPYkiQgSjRCvTpPf/f0OwtLIXlGAICZ5vyAhXWWTgcXCwj50NszEBCthCDitY+l8ZoIMWGniZIcY4CkLY8JQaKKH28BXOiehfZHqaHazhosEMDlDBx9tNyY1t75IdLVtMkLxdXec6Ufvxqzb32kVywyyp1pvWksZVO90QkTx7Ob4CDADGaiOnQPuXSgAAAABJRU5ErkJggg==';


function draw(f) {
  var r = f.angle + Math.PI;

  context.translate(f.x, f.y);
  context.rotate(r);

  var w = 20;
  var acc = py(f.dx - f.ox, f.dy - f.oy) / 0.05;

 
  if (acc > 1) {
    w = 10 + 10 / acc;
  }

  context.drawImage(fishBitmap, 0, 0, w, 6);
  context.rotate(-r);
  context.translate(-f.x, -f.y);
}


function py(a, b) {
  return Math.sqrt(a * a + b * b);
}


var cursor = {
  x: 0,
  y: 0
};
var cursorDown = false,
  keyDown = false;

document.onmousemove = function(e) {
  cursor.x = e.pageX - (window.innerWidth / 2 - canvas.width / 2);
  cursor.y = e.pageY - (window.innerHeight / 2 - canvas.height / 2);
}

document.onmouseout = function(e) { 
  cursor.y = cursor.x = Number.MAX_VALUE;
}

document.onmousedown = function() {
  activateSpeedBoost();
  cursorDown = true;
}
document.onmouseup = function() {
  cursorDown = false;
}

document.onkeydown = function() {
  keyDown = true;
}

document.onkeyup = function() {
    keyDown = false;
  }


function deltaAngle(f, o) { 
  var r = f - o;
  return Math.atan2(Math.sin(r), Math.cos(r));
}

function affinityLine(f, o, c) { 
  var grad = context.createLinearGradient(f.x, f.y, o.x, o.y);
  grad.addColorStop(0, c);
  grad.addColorStop(1, "black");

  context.strokeStyle = grad;
  context.beginPath();
  context.moveTo(f.x, f.y);
  context.lineTo(o.x, o.y);
  context.stroke();
}

function activateSpeedBoost() {
  speedBoostCountdown = 400 + Math.round(400 * Math.random());
  speedBoost = SPEED_BOOST;
}


function update() {
    if (fishes.length < 500) {
      fishes.push(new Fish(fishes.length));
    }

    if (!cursorDown) {
  
      canvas.width = canvas.width; 

  
      for (var i = 0; i < fishes.length; i++) {
        var fish = fishes[i];
        fish.calc();
        draw(fish);
      }
    }

    speedBoostCountdown--;
    if (speedBoostCountdown < 0) {
      activateSpeedBoost();
    }

    if (speedBoost > 0) {
      speedBoost -= SPEED_BOOST / 80; 
    } else {
      speedBoost = 0;
    }

    requestAnimationFrame(update);
  }
